package domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private final EnumMap<Prize, Integer> winningLottoCount;

    public LottoStatistics(EnumMap<Prize, Integer> winningLottoCount) {
        if (winningLottoCount == null) {
            throw new IllegalArgumentException();
        }
        this.winningLottoCount = winningLottoCount;
    }

    public double rateOfReturn(long purchaseAmount) {
        long totalEarn = 0;

        for (Map.Entry<Prize, Integer> entry : winningLottoCount.entrySet()) {
            totalEarn += entry.getKey().getMoney() * entry.getValue();
        }

        // (평가금액 - 원금) / 원금 * 100
        return (totalEarn - purchaseAmount) / (double) purchaseAmount * 100.0d;
    }
}
