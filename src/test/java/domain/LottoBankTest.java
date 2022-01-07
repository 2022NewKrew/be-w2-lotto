package domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBankTest {

    @Test
    @DisplayName("로또 구매 갯수를 확인")
    void buyLottos() {
        // given
        LottoBank lottoBank = new LottoBank();
        int money = 15999;

        // when
        Integer lottoNumber = lottoBank.buyLottos(money);

        // then
        assertThat(lottoNumber).isEqualTo(money / 1000);
    }

    @Test
    @DisplayName("수익률 확인")
    void getProfitRate() {


    }
}