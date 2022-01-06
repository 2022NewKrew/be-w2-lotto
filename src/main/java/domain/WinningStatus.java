package domain;

import java.util.Collections;
import java.util.Map;

public class WinningStatus {
    private final Map<LottoPrize, Long> winningStatus;

    WinningStatus (Map<LottoPrize, Long> winningStatus) {
        this.winningStatus = Collections.unmodifiableMap(winningStatus);
    }

    public double getRateOfReturn(int purchaseAmount) {
        long sumOfPrize = winningStatus.entrySet().stream()
                .mapToLong( e -> e.getKey().getPrizeMoney() * e.getValue())
                .sum();

        return sumOfPrize == 0L ? 0.0 : (double)(sumOfPrize - purchaseAmount) / purchaseAmount * 100;
    }

    public Map<LottoPrize, Long> getWinningStatus() {
        return winningStatus;
    }
}
