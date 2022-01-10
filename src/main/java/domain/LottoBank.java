package domain;

import exception.InvalidPurchaseAmount;

public class LottoBank {
    private static final int MINIMUM_PURCHASE_AMOUNT = 1;
    private static final int MAXIMUM_PURCHASE_AMOUNT = 100;
    private static final int LOTTO_PRICE = 1000;

    public int buyLottos(int purchasedAmount, int manualQuantity) {
        validatePurchaseAmount(purchasedAmount, manualQuantity);
        return (purchasedAmount / LOTTO_PRICE) - manualQuantity;
    }

    private static void validatePurchaseAmount(int purchasedAmount, int manualQuantity) {
        if ((purchasedAmount/LOTTO_PRICE) < MINIMUM_PURCHASE_AMOUNT) {
            throw new InvalidPurchaseAmount(InvalidPurchaseAmount.MINIMUM_PURCHASE_AMOUNT);
        }
        if ((purchasedAmount / LOTTO_PRICE) > MAXIMUM_PURCHASE_AMOUNT) {
            throw new InvalidPurchaseAmount(InvalidPurchaseAmount.MAXIMUM_PURCHASE_AMOUNT);
        }
        if (manualQuantity > (purchasedAmount / LOTTO_PRICE)) {
            throw new InvalidPurchaseAmount(InvalidPurchaseAmount.MANUAL_COST_SHOULD_LARGER_THAN_PURCHASE_AMOUNT);
        }
        if (manualQuantity < 0) {
            throw new InvalidPurchaseAmount(InvalidPurchaseAmount.MANUAL_NUM_SHOULD_BIGGER_THAN_MINUS);
        }
    }
}
