package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoAppTest {
    LottoApp app;

    @BeforeEach
    void setUp() {
        app = new LottoApp();
    }

    @Test
    @DisplayName("주어진 금액 만큼 로또를 구매합니다.")
    void purchaseLotto() {
<<<<<<< HEAD
        int payment = 14000;
        app.purchaseLotto(payment);
        int expectedCountOfLotto = payment / Lotto.PRICE;
        assertThat(app.getCountOfLottos()).isEqualTo(expectedCountOfLotto);
        int expectedAccumPayment = payment - expectedCountOfLotto * Lotto.PRICE;
        assertThat(app.getAccumPayment()).isEqualTo(expectedAccumPayment);
=======
        Money payment = new Money(14000);
        int expectedCountOfLotto = payment.getAmount() / Lotto.PRICE;
        int expectedAccumPayment = expectedCountOfLotto * Lotto.PRICE;
        int expectedChanges = payment.getAmount() - expectedAccumPayment;

        app.purchaseLotto(payment);
        assertThat(app.getCountOfLottos()).isEqualTo(expectedCountOfLotto);
        assertThat(app.getAccumPayment()).isEqualTo(expectedAccumPayment);
        assertThat(payment.getAmount()).isEqualTo(expectedChanges);
>>>>>>> 73407950a993c8ab02b196cc1f9fecf44a984723
    }

    @Test
    void compareHowManyMatch() {
        //
    }
}