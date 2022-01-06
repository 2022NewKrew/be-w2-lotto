package domain;

import dto.LotteryReportDTO;

import java.util.List;
import java.util.Map;

public class LotteryReport {
    private final double profitRate;
    private final Map<LotteryPrize, Integer> prizeCount;

    public LotteryReport(List<LotteryTicket> lotteryTickets, LotteryResult lotteryResult, int cost) {
        prizeCount = new ReducedLotteryTickets(lotteryTickets).getPrizeCount(lotteryResult);
        int revenue = prizeCount.entrySet().stream().map(entry -> entry.getKey().getValue() * entry.getValue()).reduce(0, Integer::sum);
        profitRate = (double) (revenue - cost) / cost;
    }

    public LotteryReport(LotteryTickets lotteryTickets, LotteryResult lotteryResult) {
        int cost = lotteryTickets.getCost();
        prizeCount = lotteryTickets.getPrizeCount(lotteryResult);
        int revenue = prizeCount.entrySet().stream().map(entry -> entry.getKey().getValue() * entry.getValue()).reduce(0, Integer::sum);
        profitRate = (double) (revenue - cost) / cost;
    }

    public LotteryReportDTO toDTO() {
        return new LotteryReportDTO(profitRate, prizeCount);
    }
}
