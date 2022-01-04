package presentation.controller;

import domain.LottoOrder;
import domain.WinningNumber;
import dto.input.PurchaseDto;
import dto.input.WinningNumberDto;
import dto.output.PurchaseOutputDto;
import dto.output.ResultOutputDto;
import factory.LottoOrderFactory;
import factory.WinningNumberFactory;
import presentation.view.output.ErrorOutputView;
import presentation.view.output.OutputView;
import presentation.view.output.PurchaseOutputView;
import presentation.view.output.ResultOutputView;

public class LottoController {
    public OutputView getPurchaseResult(PurchaseDto purchaseDto){
        try{
            return getPurchaseResultView(purchaseDto);
        }catch (RuntimeException exception){
            return new ErrorOutputView(exception);
        }
    }

    private OutputView getPurchaseResultView(PurchaseDto purchaseDto){
        int purchaseAmount = purchaseDto.getPurchaseAmount();
        LottoOrder lottoOrder = LottoOrderFactory.getInstance(purchaseAmount).orElseThrow();

        PurchaseOutputDto purchaseOutputDto = new PurchaseOutputDto(lottoOrder);
        return new PurchaseOutputView(purchaseOutputDto);
    }

    public OutputView getLottoResult(WinningNumberDto winningNumberDto){
        try{
            return getLottoResultView(winningNumberDto);
        }catch (RuntimeException exception){
            return new ErrorOutputView(exception);
        }
    }

    private OutputView getLottoResultView(WinningNumberDto winningNumberDto){
        LottoOrder lottoOrder = LottoOrderFactory.getInstance().orElseThrow();
        WinningNumber winningNumber = WinningNumberFactory.getInstance(winningNumberDto.getWinningNumbers()).orElseThrow();

        ResultOutputDto resultOutputDto = lottoOrder.getResult(winningNumber);
        return new ResultOutputView(resultOutputDto);
    }
}
