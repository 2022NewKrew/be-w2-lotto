package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    @DisplayName("로또개수만큼 구매가 되어야 한다.")
    void valueOf(int count) {
        // given

        // when
        Lottos lottos = Lottos.valueOf(count);

        // then
        assertThat(lottos.getLottos()).hasSize(count);
    }
}
