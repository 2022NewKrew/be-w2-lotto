package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoBuyer {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList = new ArrayList<>();
    private final Map<Integer, Integer> result = new HashMap<>(Map.of(
            3,0,
            4,0,
            5,0,
            6,0,
            7,0
    ));
    private int purchaseAmount; // 구매 금액

    public final void start() {
        Input.openScanner();
        purchaseAmount = Input.getMoney();
        buyLotto(purchaseAmount);
        OutputView.printLottoList(lottoList);
        checkAllLotto();
        OutputView.printResult(result);
        OutputView.printYield(calculateYield());
        Input.closeScanner();
    }

    /**
     * 구매 금액 (price)에 해당하는 로또를 생성해 반환하는 메소드
     *
     * @param price : 구매 금액
     */
    public final void buyLotto(final int price) {
        final int countLotto = price / LOTTO_PRICE;

        OutputView.printCountLotto(countLotto);
        for(int i = 0; i < countLotto; i++) {
            lottoList.add(LottoMachine.generateLotto());
        }
    }

    public final void checkAllLotto() {
        final List<Integer> winningNumbers = Input.getLastWinningNumbers();
        Integer bonusBall = Input.getBonusBall();

        for(Lotto lotto : lottoList) {
            int matched = lotto.match(winningNumbers, bonusBall);
            putResult(matched);
        }
    }

    private final void putResult(int key) {
        if(key < 3) return;
        result.put(key, result.get(key) + 1);
    }

    private final int totalReward() {
        int totalReward = 0;
        for(Integer key : result.keySet()){
            totalReward += result.get(key) * LottoPrize.of(key).getReward();
        }
        return totalReward;
    }

    private final double calculateYield() { // 수익률 계산
        return (double) (totalReward() - purchaseAmount) / purchaseAmount * 100;
    }
}
