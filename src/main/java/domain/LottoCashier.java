package domain;

public class LottoCashier {
    public static final int MINIMUM_PURCHASE_AMOUNT = 1000;

    public static int buyLottos(int purchasedAmount) {
        return purchasedAmount / MINIMUM_PURCHASE_AMOUNT;
    }
}
