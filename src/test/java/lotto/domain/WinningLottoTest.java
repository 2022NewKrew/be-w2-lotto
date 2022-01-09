package lotto.domain;

import lotto.util.InputUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    @Test
    @DisplayName("로또의 숫자가 6개가 아니면 에러를 발생하는지")
    void test4() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5)));
    }

    @Test
    @DisplayName("입력한 숫자 중 중복되는 값이 있으면 에러를 발생하는지")
    void test5() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5,5)));
    }

}