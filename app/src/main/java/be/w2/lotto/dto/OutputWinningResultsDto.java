package be.w2.lotto.dto;

import be.w2.lotto.domain.winningresult.WinningResult;
import be.w2.lotto.domain.winningresult.WinningResults;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class OutputWinningResultsDto {
    public final List<WinningResultDto> winningResultDtos;

    public final BigInteger profitRate;

    public static class WinningResultDto {
        public final int matchedNumber;
        public final int reward;
        public final int count;
        public final boolean isBonusRound;

        public WinningResultDto(WinningResult winningResult) {
            this.matchedNumber = winningResult.getMatchedNumber();
            this.reward = winningResult.getReward();
            this.count = winningResult.getCount();
            this.isBonusRound = winningResult.isBonusRound();
        }
    }

    private OutputWinningResultsDto(List<WinningResultDto> winningResultDtos, BigInteger profitRate) {
        this.winningResultDtos = winningResultDtos;
        this.profitRate = profitRate;
    }

    public static OutputWinningResultsDto from(WinningResults winningResult) {
        List <WinningResultDto> winningResultDtos = winningResult.getWinningMatchResults().stream()
                .map(WinningResultDto::new)
                .collect(Collectors.toList());
        return new OutputWinningResultsDto(winningResultDtos, winningResult.getProfitRate());
    }
}
