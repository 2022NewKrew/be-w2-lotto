package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    @DisplayName("주문한 개수만큼 로또가 구매되어야 한다.")
    void test_CreateLottos_WhenCountIsGiven(int count) {
        // given

        // when
        Lottos lottos = Lottos.valueOf(count);

        // then
        assertThat(lottos.getLottos()).hasSize(count);
    }
}
