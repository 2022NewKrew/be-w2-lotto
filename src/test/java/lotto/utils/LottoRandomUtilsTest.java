package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoRandomUtilsTest {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int EXPECTED_SIZE = 6;

    @RepeatedTest(100)
    @DisplayName("중복되지 않은 6개 숫자가 나와야 한다.")
    void getLottoNumbersDuplicateTest() {
        // given

        // when
        List<Integer> numbers = LottoRandomUtils.getNumbers();

        // then
        assertThat(new HashSet<>(numbers)).hasSize(EXPECTED_SIZE);
    }

    @RepeatedTest(100)
    @DisplayName("나온 숫자는 1~45 사이여야 한다.")
    void getLottoNumbersBoundTest() {
        // given

        // when
        List<Integer> numbers = LottoRandomUtils.getNumbers();

        // then
        assertThat(numbers.stream()
            .filter(this::isBoundIn))
            .hasSize(EXPECTED_SIZE);
    }

    private boolean isBoundIn(Integer number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}
