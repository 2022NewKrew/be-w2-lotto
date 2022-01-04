package domain;

import java.util.EnumMap;

public class Report {
    public final int investment, prizeSum;
    public final EnumMap<Prize, Integer> prizeCount;

    public Report(int investment, EnumMap<Prize, Integer> prizeCount) {
        this.investment = investment;
        this.prizeCount = prizeCount;
        final int[] sum = {0};
        prizeCount.forEach((prize, count) -> sum[0] += prize.getValue() * count);
        prizeSum = sum[0];
    }

    public double getProfitRate() {
        return (double) (prizeSum - investment) / investment;
    }
}
