package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("숫자의 개수가 6개인지 검증")
    @Test
    void getNumbers() {
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers.size())
                .isEqualTo(Lotto.NUMBER);
    }
}