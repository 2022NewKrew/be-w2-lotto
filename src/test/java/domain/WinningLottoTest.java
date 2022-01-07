package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private static final WinningLotto winningLotto = WinningLotto.create(createBallList(List.of(1, 2, 3, 4, 5, 6)), Ball.create(7));

    private static List<Ball> createBallList(List<Integer> list) {
        return list.stream()
                .map(Ball::create)
                .collect(Collectors.toList());
    }

    @DisplayName("로또의 일치 개수가 정확한지 검증")
    @Test
    void isCorrectLottoMatchCount() {
        List<Lotto> userLottoList = List.of(
                Lotto.create(createBallList(List.of(4, 5, 6, 1, 2, 3))),
                Lotto.create(createBallList(List.of(4, 5, 6, 1, 2, 45))),
                Lotto.create(createBallList(List.of(4, 5, 6, 1, 44, 45))),
                Lotto.create(createBallList(List.of(4, 5, 6, 43, 44, 45)))
        );

        List<Integer> matchList = userLottoList.stream()
                .map(winningLotto::checkNumberOfWinning)
                .collect(Collectors.toList());

        assertThat(matchList)
                .isEqualTo(List.of(6, 5, 4, 3));
    }

    @DisplayName("보너스 공을 포함하는지 확인하는 로직 검증")
    @Test
    void isContainBonusBall() {
        Lotto lottoIncludingBonusBall = Lotto.create(createBallList(List.of(1, 2, 3, 4, 5, 7)));
        Lotto lottoNotIncludingBonusBall = Lotto.create(createBallList(List.of(1, 2, 3, 4, 5, 8)));

        boolean includingBonusBall = winningLotto.checkBonusBallMatched(lottoIncludingBonusBall);
        boolean notIncludingBonusBall = winningLotto.checkBonusBallMatched(lottoNotIncludingBonusBall);

        assertThat(includingBonusBall).isTrue();
        assertThat(notIncludingBonusBall).isFalse();
    }
}