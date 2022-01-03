package be.w2.lotto.domain;

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

    private static void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_AMOUNT_LOWERBOUND) {
            throw new IllegalArgumentException("로또 구매금액은 최소 0 이상 가능합니다.");
        }
    }

    private static final int LOTTO_AMOUNT_LOWERBOUND = 0;
}
