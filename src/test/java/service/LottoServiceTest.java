package service;

import controller.LottoController;
import domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LottoService 테스트")
class LottoServiceTest {

    LottoController lottoController = new LottoController();

    @DisplayName("정수(돈)을 가지고 로또를 구매했을 때 만들어지는 로또의 개수가 정수 / Lotto.LOTTO_PRICE와 같다.")
    @Test
    void buyLottos() {
        //Give
        int money = 10000;
        //When
        lottoController.buyLottos(money);
        //Then
        assertThat(lottoController.getLottoDTOs().size() == money / Lotto.LOTTO_PRICE).isTrue();
    }

}
