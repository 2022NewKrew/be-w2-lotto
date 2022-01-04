package presentation.controller;

import domain.LottoOrder;
import domain.WinningNumber;
import dto.InputResultDto;
import dto.ResultDto;
import presentation.view.OutputView;

public class LottoController {
    public OutputView getLottoResult(InputResultDto inputResultDto){
        LottoOrder lottoOrder = inputResultDto.getLottoOrder();
        WinningNumber winningNumber = inputResultDto.getWinningNumber();

        ResultDto resultDto = lottoOrder.getResult(winningNumber);

        return new OutputView(resultDto);
    }
}
