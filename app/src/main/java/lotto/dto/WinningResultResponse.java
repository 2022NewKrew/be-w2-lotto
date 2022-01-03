package lotto.dto;

import java.util.Map;

public class WinningResultResponse {
    private Map<Integer, Integer> winningResult;
    private int earningRate;

    public WinningResultResponse(Map<Integer, Integer> winningResult, int earningRate) {
        this.winningResult = winningResult;
        this.earningRate = earningRate;
    }

    public Map<Integer, Integer> getWinningResult() {
        return winningResult;
    }

    public int getEarningRate() {
        return earningRate;
    }
}
