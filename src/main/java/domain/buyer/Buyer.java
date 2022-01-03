package domain.buyer;

import domain.lotto.Lotto;
import domain.result.Winning;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private final Price buyingPrice; //로또 구매 가격
    private final List<Lotto> buyingLottos; //구매한 로또들의 번호
    private Price earningPrice; //로또를 통해 번 돈
    private Yield yield; //수익률

    public Buyer(int price) {
        buyingPrice = new Price(price);
        buyingLottos = new ArrayList<>();
    }

    public List<Lotto> getBuyingLottos() {
        return buyingLottos;
    }

    public Yield getYield() {
        return yield;
    }

    public void calculateEarningInfo(List<Integer> hittingTable, int minHittingCnt, int maxHittingCnt) {
        calculateEarningPrice(hittingTable, minHittingCnt, maxHittingCnt);
        calculateYied();
    }

    //로또를 통해 번 돈 계산
    public void calculateEarningPrice(List<Integer> hittingTable, int minHittingCnt, int maxHittingCnt) {
        int totalPrice = 0;

        for (int i = minHittingCnt; i <= maxHittingCnt; i++) {
            int priceOfHitting = Winning.priceOfHitting(i);

            totalPrice += priceOfHitting * hittingTable.get(i);
        }

        earningPrice = new Price(totalPrice);
    }

    //슈익률 계산
    public void calculateYied() {
        double result = (double) earningPrice.getPrice() / (double) buyingPrice.getPrice() * 100;
        yield = new Yield((int) result);
    }

    public void buyingManyByRandom(int buyingCnt) {
        for (int i = 0; i < buyingCnt; i++) {
            buyingOneByRandom();
        }
    }

    //랜덤으로 로또 하나 구매
    private void buyingOneByRandom() {
        buyingLottos.add(Lotto.makeOneRandomLotto());
    }
}
