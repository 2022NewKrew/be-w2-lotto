package domain;

import exception.InvalidPurchaseAmount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBankTest {

    @Test
    @DisplayName("로또 구매 갯수를 확인(최소1장, 최대100장)")
    void buyLottos() {
        // given
        LottoBank lottoBank = new LottoBank();
        int money1 = 15999;
        int money2 = 1_001_000;
        int money3 = 999;

        // when
        Integer lottoNumber1 = lottoBank.buyLottos(money1);
        InvalidPurchaseAmount throw1 = Assertions.assertThrows(InvalidPurchaseAmount.class, () -> {
            lottoBank.buyLottos(money2);
        });
        InvalidPurchaseAmount throw2 = Assertions.assertThrows(InvalidPurchaseAmount.class, () -> {
            lottoBank.buyLottos(money3);
        });

        // then
        assertThat(lottoNumber1).isEqualTo(money1 / 1000);
        Assertions.assertEquals("최대 로또 100장까지만 구매가능합니다.", throw1.getMessage());
        Assertions.assertEquals("최소한 로또 1장 이상을 구매해야합니다.", throw2.getMessage());

    }
}