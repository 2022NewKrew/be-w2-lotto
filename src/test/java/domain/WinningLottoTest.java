package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private final WinningLotto winningLotto = createWinningLotto(createBall(List.of(1, 2, 3, 4, 5, 6)));

    private List<Ball> createBall(List<Integer> list) {
        return list.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    private Lotto createLotto(List<Ball> balls) {
        return new Lotto(balls);
    }

    private WinningLotto createWinningLotto(List<Ball> balls) {
        return new WinningLotto(balls);
    }

    @DisplayName("로또의 일치 개수가 정확한지 검증")
    @Test
    void compareTo() {
        List<Lotto> userLottoList = List.of(
                createLotto(createBall(List.of(4, 5, 6, 1, 2, 3))),
                createLotto(createBall(List.of(4, 5, 6, 1, 2, 45))),
                createLotto(createBall(List.of(4, 5, 6, 1, 44, 45))),
                createLotto(createBall(List.of(4, 5, 6, 43, 44, 45)))
        );

        List<Integer> matchList = userLottoList.stream()
                .map(winningLotto::checkNumberOfWinning)
                .collect(Collectors.toList());

        assertThat(matchList)
                .isEqualTo(List.of(6, 5, 4, 3));
    }
}