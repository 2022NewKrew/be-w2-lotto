package lottoStage1;

import lottoStage1.domain.Lotto;
import lottoStage1.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("입력한 가격에 맞게 로또를 구매")
    void purchase() {
        Lottos lottos = Lottos.purchase(14900);
        List<Lotto> lottoList = lottos.getLottos();
        assertThat(lottoList.size()).isEqualTo(14);
    }
}