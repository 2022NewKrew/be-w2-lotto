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
        int payment = 14000;
        app.purchaseLotto(payment);
        int expectedCountOfLotto = payment / Lotto.PRICE;
        assertThat(app.getCountOfLottos()).isEqualTo(expectedCountOfLotto);
        int expectedAccumPayment = payment - expectedCountOfLotto * Lotto.PRICE;
        assertThat(app.getAccumPayment()).isEqualTo(expectedAccumPayment);
    }

    @Test
    void compareHowManyMatch() {
        //
    }
}