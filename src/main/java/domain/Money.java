package domain;

import java.util.Map;

public class Money {
    private final static String MONEY_RANGE_ERROR_MESSAGE = "[ERROR] 구입금액은 0원 이상이어야 합니다.";

    private final static int LOTTO_PURCHASE_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private static void validateMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MONEY_RANGE_ERROR_MESSAGE);
        }
    }

    public int moneyOfPurchaseLotto() {
        return this.money - this.money % LOTTO_PURCHASE_PRICE;
    }

    public int countOfPurchaseLotto() {
        return this.money / LOTTO_PURCHASE_PRICE;
    }

    public float calculateProfitRate(Map<Rank, Integer> winningStatistics) {
        int money = this.moneyOfPurchaseLotto();
        float totalProfitMoney = calculateProfitMoney(winningStatistics);
        return (totalProfitMoney - money) / money * 100;
    }

    private float calculateProfitMoney(Map<Rank, Integer> winningStatistics) {
        float totalProfitMoney = 0.0f;
        final Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            int countOfWinningRank = winningStatistics.getOrDefault(rank, 0);
            totalProfitMoney += rank.calculateProfitMoney(countOfWinningRank);
        }
        return totalProfitMoney;
    }
}
