package dto.input;

public class PurchaseDto {
    private final int purchaseAmount;

    public PurchaseDto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
