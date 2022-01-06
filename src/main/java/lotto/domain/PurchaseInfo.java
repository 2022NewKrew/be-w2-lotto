package lotto.domain;

public class PurchaseInfo {
    public static final int PRICE = 1000;

    private final int purchaseAmount;
    private final int numOfPurchase;
    private final int manualLottoCount;

    public PurchaseInfo(int purchaseAmount, int manualLottoCount) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoCount = manualLottoCount;
        this.numOfPurchase = this.purchaseAmount / PRICE;
    }

    public static int getInitialNumOfPurchase(int purchaseAmount) {
        return purchaseAmount / PRICE;
    }

    public int getPurchaseAmount() { return purchaseAmount; }

    public int getNumOfPurchase() {
        return numOfPurchase;
    }

    public int getManualLottoCount() { return manualLottoCount; }
}
