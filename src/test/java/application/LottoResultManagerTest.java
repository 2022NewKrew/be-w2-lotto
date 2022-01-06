package application;

import domain.Ball;
import domain.Lotto;
import domain.MatchStatus;
import domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class LottoResultManagerTest {
    private static final WinningLotto winningLotto = createWinningLotto(createBallList(List.of(1, 2, 3, 4, 5, 6)), createBall(7));
    private static final List<Lotto> lottoList = List.of(
            createLotto(createBallList(List.of(4, 5, 6, 1, 2, 3))),
            createLotto(createBallList(List.of(4, 5, 6, 1, 2, 45))),
            createLotto(createBallList(List.of(4, 5, 6, 1, 2, 7))),
            createLotto(createBallList(List.of(4, 5, 6, 1, 44, 45))),
            createLotto(createBallList(List.of(4, 5, 6, 43, 44, 45))),
            createLotto(createBallList(List.of(4, 41, 42, 43, 44, 45))),
            createLotto(createBallList(List.of(40, 41, 42, 43, 44, 45)))
    );
    private final List<Long> prizeList = List.of(5000L, 50000L, 1500000L, 30000000L, 2000000000L);

    private static Ball createBall(int number) {
        return new Ball(number);
    }

    private static List<Ball> createBallList(List<Integer> list) {
        return list.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    private static Lotto createLotto(List<Ball> balls) {
        return new Lotto(balls);
    }

    private static WinningLotto createWinningLotto(List<Ball> balls, Ball bonusBall) {
        return new WinningLotto(balls, bonusBall);
    }

    @DisplayName("당첨 결과가 올바른지 검증")
    @Test
    void isResultCorrect() {
        LottoResultManager resultManager = new LottoResultManager(winningLotto, lottoList);

        Map<MatchStatus, Integer> result = resultManager.getMatchingResult();

        assertThat(result.entrySet())
                .extracting(Map.Entry::getKey, Map.Entry::getValue)
                .containsExactly(
                        tuple(MatchStatus.NOTHING, 2),
                      tuple(MatchStatus.THREE_MATCHES, 1),
                        tuple(MatchStatus.FOUR_MATCHES, 1),
                        tuple(MatchStatus.FIVE_MATCHES, 1),
                        tuple(MatchStatus.FIVE_MATCHES_AND_BONUS, 1),
                        tuple(MatchStatus.ALL_MATCHES, 1),
                        tuple(MatchStatus.INVALID, 0)
                );
    }

    @DisplayName("총 상금이 올바른지 검증")
    @Test
    void isTotalPrizeMoneyCorrect() {
        LottoResultManager resultManager = new LottoResultManager(winningLotto, lottoList);

        resultManager.getMatchingResult();
        Long totalPrizeMoney = resultManager.getTotalPrizeMoney();

        assertThat(totalPrizeMoney)
                .isEqualTo(prizeList.stream().reduce(0L, Long::sum));
    }
}