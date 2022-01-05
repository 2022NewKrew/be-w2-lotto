package dto;

import domain.LotteryPrize;

import java.util.Map;

public class LotteryReportDTO {
    public final double profitRate;
    public final Map<LotteryPrize, Integer> prizeCount;

    public LotteryReportDTO(double profitRate, Map<LotteryPrize, Integer> prizeCount) {
        this.profitRate = profitRate;
        this.prizeCount = prizeCount;
    }
}
