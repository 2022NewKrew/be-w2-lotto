package lotto.dto;

import lotto.domain.lotto.result.WinningRanking;

import java.util.Map;

public class WinningResultOutput {
    private final Map<WinningRanking, Long> winningResult;
    private final int earningRate;

    public WinningResultOutput(Map<WinningRanking, Long> winningResult, int earningRate) {
        this.winningResult = winningResult;
        this.earningRate = earningRate;
    }

    public Map<WinningRanking, Long> getWinningResult() {
        return winningResult;
    }

    public int getEarningRate() {
        return earningRate;
    }
}
