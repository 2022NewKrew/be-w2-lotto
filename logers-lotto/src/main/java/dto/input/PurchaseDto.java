package dto.input;

import java.util.List;

public class PurchaseDto {
    private final int purchaseAmount;
    private final List<List<Integer>> manualLottoNumbers;

    public PurchaseDto(int purchaseAmount, List<List<Integer>> manualLottoNumbers) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<List<Integer>> getManualLottoNumbers() {
        return manualLottoNumbers;
    }
}
