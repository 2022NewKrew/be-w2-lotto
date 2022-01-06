package lotto.dto;

import lotto.domain.LottoPrice;

import java.util.List;

public class LottoPurchaseRequestDto {

    private final int totalPurchaseCount;
    private final int manualPurchaseCount;
    private final List<List<Integer>> lottoNumbersList;

    public LottoPurchaseRequestDto(int totalPurchaseAmount, int manualPurchaseCount, List<List<Integer>> lottoNumbersList) {
        this.totalPurchaseCount = LottoPrice.calculateLottoPurchaseCount(totalPurchaseAmount);
        this.manualPurchaseCount = manualPurchaseCount;
        this.lottoNumbersList = lottoNumbersList;
    }

    public int getTotalPurchaseCount() {
        return totalPurchaseCount;
    }

    public int getManualPurchaseCount() {
        return manualPurchaseCount;
    }

    public List<List<Integer>> getLottoNumbersList() {
        return lottoNumbersList;
    }
}
