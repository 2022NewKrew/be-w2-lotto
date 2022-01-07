package be.w2.lotto.domain.lottoticket;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static be.w2.lotto.common.exception.PurchaseAmountLowerboundException.PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION;
import static be.w2.lotto.domain.lottoticket.LottoTicket.LOTTO_TICKET_PRICE;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoAmountTest {

    @Test
    void createLottoAmount_입력한_purchaseAmount로_LottoAmount를_계산해_반환한다() {
        // given
        int purchaseAmount = 15000;
        int expected = purchaseAmount / LOTTO_TICKET_PRICE;

        // when
        int actual = LottoTicketAmount.createLottoAmount(purchaseAmount);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void validatePurchaseAmount_입력받은_purchaseAmount가_LOWER_BOUND_초과일때_validation에_통과한다() {
        // given
        int purchaseAmount = 15000;

        // when
        Executable actual = () -> LottoTicketAmount.validatePurchaseAmount(purchaseAmount);

        // then
        assertDoesNotThrow(actual);
    }

    @Test
    void validatePurchaseAmount_입력받은_purchaseAmount가_LOWER_BOUND_이하일때_에러를_throw한다() {
        // given
        int purchaseAmount = 0;

        // when
        ThrowableAssert.ThrowingCallable actual = () -> LottoTicketAmount.validatePurchaseAmount(purchaseAmount);

        // then
        assertThatThrownBy(actual)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_LOWERBOUND_EXCEPTION);
    }
}
