package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    private final Lotto lotto = new Lotto(createBallList(List.of(1, 2, 3, 4, 5, 6)));

    private Ball createBall(int number) {
        return new Ball(number);
    }
    
    private List<Ball> createBallList(List<Integer> list) {
        return list.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    @DisplayName("숫자의 개수가 6개인지 검증")
    @Test
    void getNumbers() {
        List<Ball> numbers = lotto.getBalls();

        assertThat(numbers.size())
                .isEqualTo(Lotto.NUMBER_OF_BALLS);
    }

    @DisplayName("숫자의 개수가 6개가 아니면 에러 발생")
    @Test
    void assertBallsNumberInvalid() {
        List<Ball> invalidBallList = createBallList(List.of(1, 2, 3, 4, 5));

        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidBallList));
    }

    @DisplayName("중복된 숫자가 있으면 에러 발생")
    @Test
    void assertDuplicatedNumber() {
        List<Ball> invalidBallList = createBallList(List.of(1, 2, 3, 4, 5, 5));

        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidBallList));
    }
    
    @DisplayName("특정 숫자를 포함하고 있는지 검증")
    @Test
    void isContainBall() {
        Ball includingBall = createBall(1);
        Ball notIncludingBall = createBall(45);

        boolean contain = lotto.containBall(includingBall);
        boolean notContain = lotto.containBall(notIncludingBall);

        assertThat(contain).isTrue();
        assertThat(notContain).isFalse();
    }
}