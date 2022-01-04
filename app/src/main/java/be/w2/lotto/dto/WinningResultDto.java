package be.w2.lotto.dto;

import be.w2.lotto.domain.WinningResult;

import java.util.List;
import java.util.stream.Collectors;

public class WinningResultDto {
    public final List<WinningMatchResultDto> winningMatchResultDtos;

    public final int profitRate;

    private WinningResultDto(List<WinningMatchResultDto> winningMatchResultDtos, int profitRate) {
        this.winningMatchResultDtos = winningMatchResultDtos;
        this.profitRate = profitRate;
    }

    public static WinningResultDto from(WinningResult winningResult) {
        List <WinningMatchResultDto> winningMatchResultDtos = winningResult.getWinningMatchResults()
                .stream().map(WinningMatchResultDto::from)
                .collect(Collectors.toList());
        return new WinningResultDto(winningMatchResultDtos, winningResult.getProfitRate());
    }
}
