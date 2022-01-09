package lotto.domain;

import lotto.constant.Rank;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> rankCount;
    private final double profit;

    public LottoStatistics(Map<Rank, Integer> rankCount, double profit) {
        this.rankCount = rankCount;
        this.profit = profit;
    }

    public static LottoStatistics of(RankCollection rankCollection, LottoPurchaseInfo purchaseInfo) {
        Map<Rank, Integer> rankCount = createRankCount();
        int winningAmount = 0;
        for (Rank rank : rankCollection.getRankCollection()) {
            rankCount.put(rank, rankCount.get(rank) + 1);
            winningAmount += rank.getWinningMoney();
        }
        return new LottoStatistics(rankCount, calculateProfit(purchaseInfo, winningAmount));
    }

    private static Map<Rank, Integer> createRankCount() {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
        return rankCount;
    }

    private static double calculateProfit(LottoPurchaseInfo purchaseInfo, int winningAmount) {
        return ((double) winningAmount - purchaseInfo.getMoney()) / purchaseInfo.getMoney() * 100;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double getProfit() {
        return profit;
    }
}
