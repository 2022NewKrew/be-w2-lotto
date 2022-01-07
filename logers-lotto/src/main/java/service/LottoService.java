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
        LottoOrder lottoOrder = createLottoOrder(purchaseDto);
        return new PurchaseResultDto(lottoOrder.getLottoNumberLists());
    }

    private LottoOrder createLottoOrder(PurchaseDto purchaseDto){
        int purchaseAmount = purchaseDto.getPurchasePrice();
        List<List<Integer>> manualLottoNumberLists = purchaseDto.getManualLottoNumberLists();

        return LottoOrderFactory
                .getInstance(purchaseAmount, manualLottoNumberLists)
                .orElseThrow();
    }

    public RewardResultDto matchingWith(WinningNumbersDto winningNumbersDto){
        WinningNumbers winningNumbers = createWinningNumbers(winningNumbersDto);
        return matchedBy(winningNumbers);
    }

    private WinningNumbers createWinningNumbers(WinningNumbersDto winningNumbersDto){
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
