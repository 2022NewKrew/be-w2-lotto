package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.domain.lottoticket.LottoTicketAmount;
import org.junit.jupiter.api.Test;

import static be.w2.lotto.common.exception.ExceptionMessages.PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION;
import static be.w2.lotto.domain.lottoticket.LottoTicket.LOTTO_TICKET_PRICE;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoAmountTest {

    @Test
    void getLottoAmount_입력한_purchaseAmount로_LottoAmount를_계산해_반환한다() {
        // given
        int purchaseAmount = 15000;
        int expected = purchaseAmount / LOTTO_TICKET_PRICE;

        // when
        int lottoAmount = LottoTicketAmount.createLottoAmount(purchaseAmount);

        // then
        assertThat(lottoAmount).isEqualTo(expected);
    }

    @Test
    void validatePurchaseAmount_입력받은_purchaseAmount가_LOWER_BOUND_초과일때_validation에_통과한다() {
        // given
        int purchaseAmount = 15000;

        // when - then
        assertDoesNotThrow(() -> LottoTicketAmount.validatePurchaseAmount(purchaseAmount));
    }

    @Test
    void validatePurchaseAmount_입력받은_purchaseAmount가_LOWER_BOUND_이하일때_에러를_throw한다() {
        // given
        int purchaseAmount = 0;

        // when - then
        assertThatThrownBy(() -> LottoTicketAmount.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION);
    }
}
