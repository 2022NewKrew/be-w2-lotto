package model;

public class LottoResult {

    private LottoResult() {
    }

    public static long calculateTotalWinningAmount(RankResult rankResults) {
        long totalWinningAmount = 0;

        for(LottoRanks rank: LottoRanks.values()){
            totalWinningAmount += (long) rankResults.getCountByRank(rank) * rank.getWinningMoney();
        }

        return totalWinningAmount;
    }

    public static long calculateYield(long totalWinningAmount, int purchaseAmount) {
        return (totalWinningAmount - purchaseAmount) / purchaseAmount * 100;
    }
}
