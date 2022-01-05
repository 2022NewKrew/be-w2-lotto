package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호는 6개 숫자이고, 모든 숫자는 1~45 사이의 숫자이면 된다.")
    void correctLottoNumbersTest() {
        // given
        List<Integer> numbers = Arrays.asList(1,11,21,31,41,45);

        // when
        // then
        assertDoesNotThrow(() -> new LottoNumbers(numbers));
    }

    @Test
    @DisplayName("로또 번호는 6개여야만 한다.")
    void lottoNumbersSizeTest(){
        // given
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5);

        // when
        Throwable e1 = assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(numbers1));
        Throwable e2 = assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(numbers2));

        // then
        assertThat(e1.getMessage()).isEqualTo("로또 번호는 6개여야만 합니다.");
        assertThat(e2.getMessage()).isEqualTo("로또 번호는 6개여야만 합니다.");
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다.")
    void lottoNumbersDuplicateTest(){
        // given
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1);

        // when
        Throwable e = assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(numbers));

        // then
        assertThat(e.getMessage()).isEqualTo("로또 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("로또 번호 1~45 사이의 숫자여야 한다.")
    void lottoNumbersTest(){
        // given
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5,46);
        List<Integer> numbers2 = Arrays.asList(0,1,2,3,4,5);

        // when
        Throwable e1 = assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(numbers1));
        Throwable e2 = assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(numbers2));

        // then
        assertThat(e1.getMessage()).isEqualTo("로또 번호는 1~45 사이의 숫자여야 합니다.");
        assertThat(e2.getMessage()).isEqualTo("로또 번호는 1~45 사이의 숫자여야 합니다.");
    }
}
