package be.w2.lotto.cashier;

import be.w2.lotto.exceptions.NonValidPurchaseAmountException;
import be.w2.lotto.messages.ErrorMessage;
import be.w2.lotto.precondition.Precondition;

public class Cashier {
    private static final int PRICE_PER_LOTTO = 1000;

    public static int getNumOfLottoForPurchaseAmount(int purchaseAmount) {
        Precondition.notLessThanInt(purchaseAmount, 0, new NonValidPurchaseAmountException(ErrorMessage.PURCHASE_AMOUNT_SHOULD_BE_POSITIVE));
        return purchaseAmount / PRICE_PER_LOTTO;
    }
}
