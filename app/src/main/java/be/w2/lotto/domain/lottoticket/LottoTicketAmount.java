package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.common.exception.ForbiddenInstanceException;
import be.w2.lotto.common.exception.PurchaseAmountLowerboundException;

import static be.w2.lotto.domain.lottoticket.LottoTicket.LOTTO_TICKET_PRICE;

public class LottoTicketAmount {
    private LottoTicketAmount() throws ForbiddenInstanceException {
        throw new ForbiddenInstanceException();
    }

    public static int createLottoAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public static void validatePurchaseAmount(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount <= LOTTO_AMOUNT_LOWERBOUND) {
            throw new PurchaseAmountLowerboundException();
        }
    }

    private static final int LOTTO_AMOUNT_LOWERBOUND = 0;
}
