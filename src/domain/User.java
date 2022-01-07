package domain;

import jdk.jfr.DataAmount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements IUser {
    private long price;
    private final List<Lotto> lottoList = new ArrayList<>();
    private int numberOfBuy;
    private int numberOfManual;
    private double profitRatio = 0;
    private int profit = 0;
    private Map<Ranking, Integer> ranking = new HashMap<>();

    public static final LottoMachine lottoMachine = LottoMachine.getInstance();

    public User() {
    }

    public void purchase(int price, int numberOfManual, List<String> manualList) {
        this.price = price;
        this.numberOfBuy = (int) (this.price / Lotto.PRICE);
        this.numberOfManual = numberOfManual;
        lottoList.addAll(lottoMachine.purchaseManualLotto(manualList));
        lottoList.addAll(lottoMachine.purchaseAutoLotto(numberOfBuy - numberOfManual));
    }

    public void lotteryDraw() {
        ranking.clear();
        for (Ranking rank : Ranking.values()) {
            ranking.put(rank, 0);
        }

        for (Lotto lotto : lottoList) {
            int same = lottoMachine.getWinning().getCountOfSame(lotto);
            boolean matchBonus = lottoMachine.getWinning().mathBonus(lotto);
            Ranking rank = Ranking.valueOf(same, matchBonus);
            ranking.replace(rank, ranking.get(rank) + 1);
        }
    }

    public void calculateProfit() {
        profit = 0;
        for (Ranking rank : Ranking.values()) {
            profit += rank.getPrice() * ranking.get(rank);
        }
        profitRatio = (double) (profit - price) / price * 100;
    }

    public long getPrice() {
        return this.price;
    }

    public int getNumberOfBuy() {
        return this.numberOfBuy;
    }

    public int getNumberOfManual() {
        return this.numberOfManual;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public double getProfitRatio() {
        return this.profitRatio;
    }

    public int getProfit() {
        return this.profit;
    }

    public Integer getRanking(Ranking rank) {
        return this.ranking.get(rank);
    }
}
