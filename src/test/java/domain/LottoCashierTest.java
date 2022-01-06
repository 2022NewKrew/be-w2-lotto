package domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCashierTest {

    @Test
    @DisplayName("로또 구매 갯수를 확인")
    void buyLottos() {
        // given
        LottoCashier lottoCashier = new LottoCashier();
        int money = 15999;

        // when
        Integer lottoNumber = lottoCashier.buyLottos(money);

        // then
        assertThat(lottoNumber).isEqualTo(money / 1000);
    }

    @Test
    @DisplayName("수익률 확인")
    void getProfitRate() {


    }
}