package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    private static final int EXPECTED_SIZE = 6;

    @Test
    @DisplayName("당첨 번호의 사이즈는 6개이다.")
    void test_CreateWinningLotto_WithSixNumbers() {
        // given

        // when
        WinningLotto winningLotto = new WinningLotto();

        // then
        assertThat(winningLotto.getLotto().getNumbers()).hasSize(EXPECTED_SIZE);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("당첨 번호가 1~45를 벗어나면 에러가 발생한다.")
    void test_CreateWinningLotto_WithBoundOver(int number) {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        numbers.add(number);

        // when
        ThrowingCallable callable = () -> new WinningLotto(numbers);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("getLottoNums")
    @DisplayName("당첨 번호가 6개가 아니면 에러가 발생한다.")
    void test_CreateWinningLotto_WithNotSixNumbers(List<Integer> numbers) {
        // given

        // when
        ThrowingCallable callable = () -> new WinningLotto(numbers);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> getLottoNums() {
        return Stream.of(
            new ArrayList<>(),
            List.of(1, 2, 3, 4, 5),
            List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("당첨 번호 중 중복된 값이 있다면 에러가 발생한다.")
    void test_CreateWinningLotto_WithDuplicatedNumbers(int number) {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        numbers.add(number);

        // when
        ThrowingCallable callable = () -> new WinningLotto(numbers);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("매번 랜덤하게 당첨 번호가 생성되어야 한다.")
    void test_CreateWinningLotto_IsRandom() {
        // given
        Set<Integer> numbers = new HashSet<>();
        int repeat = 10;
        int pivot = 6;

        // when
        for (int i = 0; i < repeat; i++) {
            numbers.addAll(new WinningLotto().getLotto().getNumbers());
        }

        // then
        assertThat(numbers.size()).isNotEqualTo(pivot);
    }
}