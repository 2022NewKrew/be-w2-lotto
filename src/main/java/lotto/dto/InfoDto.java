package lotto.dto;

import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

public class InfoDto {

    private final LottosDto lottosDto;
    private final WinningLottoDto winningLottoDto;
    private final ResultDto resultDto;

    public InfoDto(LottosDto lottosDto, WinningLottoDto winningLottoDto, ResultDto resultDto) {
        this.lottosDto = lottosDto;
        this.winningLottoDto = winningLottoDto;
        this.resultDto = resultDto;
    }

    public static InfoDto valueOf(Lottos lottos, WinningLotto winningLotto, Result result) {
        LottosDto lottosDto = LottosDto.LottosToDto(lottos);
        WinningLottoDto winningLottoDto = WinningLottoDto.winningLottoToDto(winningLotto);
        ResultDto resultDto = ResultDto.resultToDto(result);
        return new InfoDto(lottosDto, winningLottoDto, resultDto);
    }

    public LottosDto getLottosDto() {
        return lottosDto;
    }

    public WinningLottoDto getWinningLottoDto() {
        return winningLottoDto;
    }

    public ResultDto getResultDto() {
        return resultDto;
    }
}
