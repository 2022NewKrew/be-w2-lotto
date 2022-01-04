package lotto.dto;

import java.util.Map;

public class WinningResultOutput {
    private final Map<String, Long> winningResult;
    private final int earningRate;

    public WinningResultOutput(Map<String, Long> winningResult, int earningRate) {
        this.winningResult = winningResult;
        this.earningRate = earningRate;
    }

    public Map<String, Long> getWinningResult() {
        return winningResult;
    }

    public int getEarningRate() {
        return earningRate;
    }
}
