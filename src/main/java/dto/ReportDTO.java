package dto;

import domain.Prize;

import java.util.Map;

public class ReportDTO {
    public final int investment, prizeSum;
    public final double profitRate;
    public final Map<Prize, Integer> prizeCount;

    public ReportDTO(int investment, Map<Prize, Integer> prizeCount) {
        this.investment = investment;
        this.prizeCount = prizeCount;
        prizeSum = prizeCount.entrySet().stream().map(entry -> entry.getKey().getValue() * entry.getValue()).reduce(0, Integer::sum);
        profitRate = (double) (prizeSum - investment) / investment;
    }
}
