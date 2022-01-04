package presentation.controller;

import domain.LottoOrder;
import domain.WinningNumber;
import dto.input.PurchaseDto;
import dto.input.WinningNumberDto;
import dto.output.PurchaseOutputDto;
import dto.output.ResultOutputDto;
import factory.LottoOrderFactory;
import presentation.view.output.PurchaseOutputView;
import presentation.view.output.ResultOutputView;

public class LottoController {
    public PurchaseOutputView getPurchaseResult(PurchaseDto purchaseDto){
        int purchaseAmount = purchaseDto.getPurchaseAmount();
        LottoOrder lottoOrder = LottoOrderFactory.createLottoOrder(purchaseAmount);

        PurchaseOutputDto purchaseOutputDto = new PurchaseOutputDto(lottoOrder);
        return new PurchaseOutputView(purchaseOutputDto);
    }

    public ResultOutputView getLottoResult(PurchaseDto purchaseDto, WinningNumberDto winningNumberDto){
        LottoOrder lottoOrder = purchaseDto.getLottoOrder();
        WinningNumber winningNumber = winningNumberDto.getWinningNumber();

        ResultOutputDto resultOutputDto = lottoOrder.getResult(winningNumber);
        return new ResultOutputView(resultOutputDto);
    }
}
