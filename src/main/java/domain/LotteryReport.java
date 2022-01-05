package domain;

import dto.LotteryReportDTO;

import java.util.Map;

public class LotteryReport {
    private final int cost, revenue;
    private final double profitRate;
    private final Map<LotteryPrize, Integer> prizeCount;

    public LotteryReport(LotteryTickets lotteryTickets, LotteryResult lotteryResult) {
        cost = lotteryTickets.getCost();
        prizeCount = lotteryTickets.getPrizeCount(lotteryResult);
        revenue = prizeCount.entrySet().stream().map(entry -> entry.getKey().getValue() * entry.getValue()).reduce(0, Integer::sum);
        profitRate = (double) (revenue - cost) / cost;
    }

    public LotteryReportDTO toDTO() {
        return new LotteryReportDTO(profitRate, prizeCount);
    }
}
