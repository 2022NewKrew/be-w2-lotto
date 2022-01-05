package presentation.controller;

import domain.LottoOrder;
import domain.RewardResult;
import domain.WinningNumbers;
import dto.input.PurchaseDto;
import dto.input.WinningNumbersDto;
import dto.output.PurchaseResultDto;
import dto.output.RewardResultDto;
import domain.factory.LottoOrderFactory;
import domain.factory.WinningNumbersFactory;
import presentation.view.output.ErrorOutputView;
import presentation.view.output.OutputView;
import presentation.view.output.PurchaseOutputView;
import presentation.view.output.ResultOutputView;

import java.util.List;

public class LottoController {
    public OutputView purchaseLotto(PurchaseDto purchaseDto){
        try{
            LottoOrder lottoOrder = createLottoOrder(purchaseDto);
            return getPurchaseOutputView(lottoOrder);
        }catch (RuntimeException exception){
            return new ErrorOutputView(exception);
        }
    }

    private LottoOrder createLottoOrder(PurchaseDto purchaseDto){
        int purchaseAmount = purchaseDto.getPurchasePrise();
        List<List<Integer>> manualLottoNumberLists = purchaseDto.getManualLottoNumberLists();

        return LottoOrderFactory
                .getInstance(purchaseAmount, manualLottoNumberLists)
                .orElseThrow();
    }

    private OutputView getPurchaseOutputView(LottoOrder lottoOrder){
        PurchaseResultDto purchaseResultDto = new PurchaseResultDto(lottoOrder.getLottoNumberLists());
        return new PurchaseOutputView(purchaseResultDto);
    }

    public OutputView matchingWith(WinningNumbersDto winningNumbersDto){
        try{
            WinningNumbers winningNumbers = createWinningNumbers(winningNumbersDto);
            return getLottoResultView(winningNumbers);
        }catch (RuntimeException exception){
            return new ErrorOutputView(exception);
        }
    }

    private WinningNumbers createWinningNumbers(WinningNumbersDto winningNumbersDto){
        return WinningNumbersFactory
                .getInstance(winningNumbersDto.getWinningNumbers(), winningNumbersDto.getBonusNumbers())
                .orElseThrow();
    }

    private OutputView getLottoResultView(WinningNumbers winningNumbers){
        LottoOrder lottoOrder = LottoOrderFactory.getInstance().orElseThrow();
        RewardResult rewardResult = lottoOrder.matchingWith(winningNumbers);

        RewardResultDto rewardResultDto
                = new RewardResultDto(rewardResult.getRewardToCount(), rewardResult.getProfitPercent());
        return new ResultOutputView(rewardResultDto);
    }
}
