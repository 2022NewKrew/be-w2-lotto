package be.w2.lotto.domain;

import static be.w2.lotto.common.exception.ExceptionMessages.PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION;
import static be.w2.lotto.domain.LottoTicket.LOTTO_TICKET_PRICE;

public class LottoAmount {
    private final int purchaseAmount;

    private LottoAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoAmount from(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return new LottoAmount(purchaseAmount);
    }

    public int getLottoAmount() {
        return this.purchaseAmount / LOTTO_TICKET_PRICE;
    }

    private static void validatePurchaseAmount(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount <= LOTTO_AMOUNT_LOWERBOUND) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION);
        }
    }

    private static final int LOTTO_AMOUNT_LOWERBOUND = 0;
}
