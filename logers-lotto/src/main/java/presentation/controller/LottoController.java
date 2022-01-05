package presentation.controller;

import domain.LottoOrder;
import domain.WinningNumber;
import dto.InputResultDto;
import dto.ResultDto;
import presentation.view.LottoResultOutputView;

public class LottoController {
    public LottoResultOutputView getLottoResult(InputResultDto inputResultDto){
        LottoOrder lottoOrder = inputResultDto.getLottoOrder();
        WinningNumber winningNumber = inputResultDto.getWinningNumber();

        ResultDto resultDto = lottoOrder.getResult(winningNumber);

        return new LottoResultOutputView(resultDto);
    }
}
