package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    @DisplayName("로또 번호는 6개여야만 한다.")
    @ParameterizedTest
    @MethodSource("invalidLottoNumberSize")
    void lottoNumbersSizeTest(List<Integer> numbers){
        // given
        // when
        Throwable e = assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(numbers));

        // then
        assertThat(e.getMessage()).isEqualTo("로또 번호는 6개여야만 합니다.");
    }

    static Stream<Arguments> invalidLottoNumberSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2, 3))
        );
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

    @DisplayName("로또 번호 1~45 사이의 숫자여야 한다.")
    @ParameterizedTest
    @MethodSource("invalidLottoNumbers")
    void lottoNumbersTest(List<Integer> numbers){
        // given
        // when
        Throwable e = assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(numbers));

        // then
        assertThat(e.getMessage()).isEqualTo("로또 번호는 1~45 사이의 숫자여야 합니다.");
    }

    static Stream<Arguments> invalidLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46)),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(10, 20, 30, 40, 45, 50)),
                Arguments.of(Arrays.asList(-10, 1, 2, 3, 4, 5))
        );
    }
}
