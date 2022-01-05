package be.w2.lotto.dto;

import be.w2.lotto.domain.winningresult.WinningResults;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class OutputWinningResultsDto {
    public final List<WinningResult> winningResults;

    public final BigInteger profitRate;

    public static class WinningResult {
        public final int matchedNumber;
        public final int reward;
        public final int count;
        public final boolean isBonusRound;

        public WinningResult(be.w2.lotto.domain.winningresult.WinningResult winningResult) {
            this.matchedNumber = winningResult.getMatchedNumber();
            this.reward = winningResult.getReward();
            this.count = winningResult.getCount();
            this.isBonusRound = winningResult.isBonusRound();
        }
    }

    private OutputWinningResultsDto(List<WinningResult> winningResults, BigInteger profitRate) {
        this.winningResults = winningResults;
        this.profitRate = profitRate;
    }

    public static OutputWinningResultsDto from(WinningResults winningResult) {
        List <WinningResult> winningResults = winningResult.getWinningMatchResults().stream()
                .map(WinningResult::new)
                .collect(Collectors.toList());
        return new OutputWinningResultsDto(winningResults, winningResult.getProfitRate());
    }
}
