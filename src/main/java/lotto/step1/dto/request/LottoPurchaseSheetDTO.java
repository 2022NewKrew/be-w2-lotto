package lotto.step1.dto.request;

public class LottoPurchaseSheetDTO {
    private final int purchaseAmount;

    public LottoPurchaseSheetDTO(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
