package lotto.domain;

public class PurchaseInfo {
    private static final int PRICE = 1000;
    private static final String PURCHASE_RESULT_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";

    private final int purchaseAmount;
    private final int numOfPurchase;
    private final int manualLottoCount;

    public PurchaseInfo(int purchaseAmount, int manualLottoCount) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoCount = manualLottoCount;
        this.numOfPurchase = this.purchaseAmount / PRICE;
        System.out.format(PURCHASE_RESULT_FORMAT, this.manualLottoCount, this.numOfPurchase - this.manualLottoCount);
    }

    public static int getNumOfPurchases(int purchaseAmount) {
        return purchaseAmount / PRICE;
    }

    public int getPurchaseAmount() { return purchaseAmount; }

    public int getNumOfPurchase() {
        return numOfPurchase;
    }

    public int getManualLottoCount() { return manualLottoCount; }
}
