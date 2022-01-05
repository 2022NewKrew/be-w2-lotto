package be.w2.lotto.domain.lottoticket;

import static be.w2.lotto.common.exception.ExceptionMessages.FORBIDDEN_INSTANCE_GENERATION_EXCEPTION;
import static be.w2.lotto.common.exception.ExceptionMessages.PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION;
import static be.w2.lotto.domain.lottoticket.LottoTicket.LOTTO_TICKET_PRICE;

public class LottoTicketAmount {
    private LottoTicketAmount() {
        throw new RuntimeException(FORBIDDEN_INSTANCE_GENERATION_EXCEPTION);
    }

    public static int getLottoAmount(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public static void validatePurchaseAmount(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount <= LOTTO_AMOUNT_LOWERBOUND) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION);
        }
    }

    private static final int LOTTO_AMOUNT_LOWERBOUND = 0;
}
