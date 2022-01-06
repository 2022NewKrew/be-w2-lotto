package domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
class LottoTest {

    @Test
    @DisplayName("로또 내에 넘버 포함 유무 확인")
    void contains() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when & then
        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }
}