package domain;

import domain.lottery.Result;
import domain.lottery.Tickets;
import dto.ReportDTO;

import java.util.Map;

public class Report {
    private final int cost, revenue;
    private final double profitRate;
    private final Map<Prize, Integer> prizeCount;

    public Report(Tickets tickets, Result result) {
        cost = tickets.getCost();
        prizeCount = tickets.getPrizeCount(result);
        revenue = prizeCount.entrySet().stream().map(entry -> entry.getKey().getValue() * entry.getValue()).reduce(0, Integer::sum);
        profitRate = (double) (revenue - cost) / cost;
    }

    public ReportDTO toDTO() {
        return new ReportDTO(profitRate, prizeCount);
    }
}
