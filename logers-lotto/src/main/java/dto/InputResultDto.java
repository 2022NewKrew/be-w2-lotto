package dto;

import domain.LottoOrder;
import domain.WinningNumber;

public class InputResultDto {
    private final LottoOrder lottoOrder;
    private final WinningNumber winningNumber;

    public InputResultDto(LottoOrder lottoOrder, WinningNumber winningNumber) {
        this.lottoOrder = lottoOrder;
        this.winningNumber = winningNumber;
    }

    public LottoOrder getLottoOrder() {
        return lottoOrder;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
