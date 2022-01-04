package lotto.step3.dto.request;

import lotto.step1.dto.request.LottoPurchaseSheetDTO;

import java.util.List;

public class NoAutoLottoPurchaseSheetDTO extends LottoPurchaseSheetDTO {
    private final List<List<Integer>> nonAutoLottoNumbersList;

    public NoAutoLottoPurchaseSheetDTO(int purchaseAmount, List<List<Integer>> nonAutoLottoNumbersList) {
        super(purchaseAmount);
        this.nonAutoLottoNumbersList = nonAutoLottoNumbersList;
    }

    public List<List<Integer>> getNonAutoLottoNumbersList() {
        return nonAutoLottoNumbersList;
    }
}
