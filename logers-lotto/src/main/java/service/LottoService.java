package service;

import domain.LottoOrder;
import domain.RewardResult;
import domain.WinningNumbers;
import domain.factory.LottoOrderFactory;
import domain.factory.WinningNumbersFactory;
import dto.input.PurchaseDto;
import dto.input.WinningNumbersDto;
import dto.output.PurchaseResultDto;
import dto.output.RewardResultDto;

import java.util.List;

public class LottoService {
    public PurchaseResultDto purchase(PurchaseDto purchaseDto){
        int purchaseAmount = purchaseDto.getPurchasePrise();
        List<List<Integer>> manualLottoNumberLists = purchaseDto.getManualLottoNumberLists();

        LottoOrder lottoOrder = LottoOrderFactory
                .getInstance(purchaseAmount, manualLottoNumberLists)
                .orElseThrow();

        return new PurchaseResultDto(lottoOrder.getLottoNumberLists());
    }

    public RewardResultDto matchingWith(WinningNumbersDto winningNumbersDto){
        WinningNumbers winningNumbers = createWinningNumbers(winningNumbersDto);
        return matchedBy(winningNumbers);
    }

    public WinningNumbers createWinningNumbers(WinningNumbersDto winningNumbersDto){
        return WinningNumbersFactory
                .getInstance(winningNumbersDto.getWinningNumbers(), winningNumbersDto.getBonusNumbers())
                .orElseThrow();
    }

    private RewardResultDto matchedBy(WinningNumbers winningNumbers){
        LottoOrder lottoOrder = LottoOrderFactory.getInstance().orElseThrow();
        RewardResult rewardResult = lottoOrder.matchingWith(winningNumbers);
        return new RewardResultDto(rewardResult.getRewardToCount(), rewardResult.getProfitPercent());
    }
}
