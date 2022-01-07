package business.domain;

public class Statistics {

    private final RankMap rankMap;
    private final RateOfYield rateOfYield;

    private Statistics(RankMap rankMap, RateOfYield rateOfYield) {
        if (!(isRankMapValid(rankMap) && isRateOfYieldValid(rateOfYield))) {
            throw new IllegalArgumentException("로또 추첨 결과 통계를 생성할 수 없습니다.");
        }
        this.rankMap = rankMap;
        this.rateOfYield = rateOfYield;
    }

    public static Statistics of(Money baseMoney, LotteryTicket lotteryTicket,
        LotteryResult lotteryResult) {
        RankMap rankmap = RankMap.of(lotteryResult, lotteryTicket);
        Money prize = rankmap.getTotalPrize();
        return new Statistics(rankmap, Money.calculateRateOfYield(baseMoney, prize));
    }

    private boolean isRateOfYieldValid(RateOfYield rateOfYield) {
        return rateOfYield != null;
    }

    private boolean isRankMapValid(RankMap rankMap) {
        return rankMap != null;
    }

    public double getRateOfYield() {
        return rateOfYield.getValue();
    }

    public long getCountOf(Rank rank) {
        return rankMap.getCountOf(rank);
    }

    @Override
    public String toString() {
        return "Statistics{" + "rankMap=" + rankMap + ", rateOfYield=" + rateOfYield + '}';
    }
}
