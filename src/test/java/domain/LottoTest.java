package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final Lotto lotto = new Lotto(createBall(List.of(1, 2, 3, 4, 5, 6)));

    private List<Ball> createBall(List<Integer> list) {
        return list.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    @DisplayName("숫자의 개수가 6개인지 검증")
    @Test
    void getNumbers() {
        List<Ball> numbers = lotto.getBalls();

        assertThat(numbers.size())
                .isEqualTo(Lotto.NUMBER);
    }
}