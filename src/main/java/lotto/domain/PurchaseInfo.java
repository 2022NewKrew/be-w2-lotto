package lotto.domain;

public class PurchaseInfo {
    private static final int PRICE = 1000;

    private final int purchaseAmount;
    private final int numOfPurchase;

    public PurchaseInfo(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        numOfPurchase = this.purchaseAmount / PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getNumOfPurchase() {
        return numOfPurchase;
    }
}
