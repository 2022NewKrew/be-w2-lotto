package lotto.domain;

public class PurchaseInfo {
    private static final int PRICE = 1000;
    private static final String PURCHASE_RESULT_FORMAT = "%d개를 구매했습니다.%n";

    private final int purchaseAmount;
    private final int numOfPurchase;

    public PurchaseInfo(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.numOfPurchase = this.purchaseAmount / PRICE;
        System.out.format(PURCHASE_RESULT_FORMAT, this.numOfPurchase);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getNumOfPurchase() {
        return numOfPurchase;
    }
}
