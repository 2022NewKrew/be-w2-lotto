package domain;

import exception.InvalidPurchaseAmount;

public class LottoCashier {
    public static final int MINIMUM_PURCHASE_AMOUNT = 1000;

    public static int buyLottos(int purchasedAmount) {
        validatePurchaseAmount(purchasedAmount);
        return purchasedAmount / MINIMUM_PURCHASE_AMOUNT;
    }

    private static void validatePurchaseAmount(int purchasedAmount) {
        if (purchasedAmount < 1000) {
            throw new InvalidPurchaseAmount(InvalidPurchaseAmount.MINIMUM_PURCHASE_AMOUNT);
        }
    }
}
