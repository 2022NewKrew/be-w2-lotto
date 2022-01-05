package presentation.controller;

import domain.LottoOrder;
import domain.WinningNumbers;
import dto.input.PurchaseDto;
import dto.input.WinningNumbersDto;
import dto.output.PurchaseResultDto;
import domain.RewardResult;
import dto.output.RewardResultDto;
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

        PurchaseResultDto purchaseResultDto = new PurchaseResultDto(lottoOrder.getLottos());
        return new PurchaseOutputView(purchaseResultDto);
    }

    public OutputView getLottoResult(WinningNumbersDto winningNumbersDto){
        try{
            return getLottoResultView(winningNumbersDto);
        }catch (RuntimeException exception){
            return new ErrorOutputView(exception);
        }
    }

    private OutputView getLottoResultView(WinningNumbersDto winningNumbersDto){
        LottoOrder lottoOrder = LottoOrderFactory.getInstance().orElseThrow();
        WinningNumbers winningNumbers = WinningNumberFactory.getInstance(winningNumbersDto.getWinningNumbers()).orElseThrow();

        RewardResult rewardResult = lottoOrder.getResult(winningNumbers);
        RewardResultDto rewardResultDto = new RewardResultDto(rewardResult.getMatchedToCount(), rewardResult.getProfitPercent());
        return new ResultOutputView(rewardResultDto);
    }
}
