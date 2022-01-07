package domain;

import java.util.Collections;
import java.util.Map;

public class WinningStatus {
    private final Map<LottoPrize, Long> winningStatus;

    WinningStatus (Map<LottoPrize, Long> winningStatus) {
        this.winningStatus = Collections.unmodifiableMap(winningStatus);
    }

    /**+
     * 수익률 = (총 당첨금 - 원금) / 원금
     * 총 당첨금이 0원일 경우 수익률은 0%로 계산합니다.
     * @param purchaseAmount 원금
     * @return 수익률
     */
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
