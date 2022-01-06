package domain;

import exception.InvalidPurchaseAmount;

public class LottoEmployee {
    private static final int MINIMUM_PURCHASE_AMOUNT = 1;
    private static final int LOTTO_PRICE = 1000;


    public static int buyLottos(int purchasedAmount) {
        validatePurchaseAmount(purchasedAmount);
        return purchasedAmount / LOTTO_PRICE;
    }

    private static void validatePurchaseAmount(int purchasedAmount) {
        if ((purchasedAmount/LOTTO_PRICE) < MINIMUM_PURCHASE_AMOUNT) {
            throw new InvalidPurchaseAmount(InvalidPurchaseAmount.MINIMUM_PURCHASE_AMOUNT);
        }
    }
}
