package dto;

import domain.Prize;

import java.util.Map;

public class ReportDTO {
    public final double profitRate;
    public final Map<Prize, Integer> prizeCount;

    public ReportDTO(double profitRate, Map<Prize, Integer> prizeCount) {
        this.profitRate = profitRate;
        this.prizeCount = prizeCount;
    }
}
