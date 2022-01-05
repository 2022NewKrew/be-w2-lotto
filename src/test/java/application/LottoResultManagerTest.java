package application;

import domain.Ball;
import domain.Lotto;
import domain.MatchingStatus;
import domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class LottoResultManagerTest {
    private final List<Long> prizeList = List.of(5000L, 50000L, 1500000L, 2000000000L);

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

    @DisplayName("당첨 결과가 올바른지 검증")
    @Test
    void isResultCorrect() {
        // given
        WinningLotto winningLotto = createWinningLotto(createBall(List.of(1, 2, 3, 4, 5, 6)));
        List<Lotto> lottoList = List.of(
                createLotto(createBall(List.of(4, 5, 6, 1, 2, 3))),
                createLotto(createBall(List.of(4, 5, 6, 1, 2, 45))),
                createLotto(createBall(List.of(4, 5, 6, 1, 44, 45))),
                createLotto(createBall(List.of(4, 5, 6, 43, 44, 45))),
                createLotto(createBall(List.of(4, 41, 42, 43, 44, 45))),
                createLotto(createBall(List.of(40, 41, 42, 43, 44, 45)))
        );
        LottoResultManager resultManager = new LottoResultManager(winningLotto, lottoList);

        // when
        Map<MatchingStatus, Integer> result = resultManager.getMatchingResult();

        //then
        assertThat(result.entrySet())
                .extracting(Map.Entry::getKey, Map.Entry::getValue)
                .containsExactly(
                        tuple(MatchingStatus.NOTHING, 2),
                      tuple(MatchingStatus.THREE_MATCHES, 1),
                        tuple(MatchingStatus.FOUR_MATCHES, 1),
                        tuple(MatchingStatus.FIVE_MATCHES, 1),
                        tuple(MatchingStatus.FIVE_MATCHES_AND_BONUS, 0),
                        tuple(MatchingStatus.ALL_MATCHES, 1),
                        tuple(MatchingStatus.INVALID, 0)
                );
    }

    @DisplayName("총 상금이 올바른지 검증")
    @Test
    void isTotalPrizeMoneyCorrect() {
        // given
        WinningLotto winningLotto = createWinningLotto(createBall(List.of(1, 2, 3, 4, 5, 6)));
        List<Lotto> lottoList = List.of(
                createLotto(createBall(List.of(4, 5, 6, 1, 2, 3))),
                createLotto(createBall(List.of(4, 5, 6, 1, 2, 45))),
                createLotto(createBall(List.of(4, 5, 6, 1, 44, 45))),
                createLotto(createBall(List.of(4, 5, 6, 43, 44, 45))),
                createLotto(createBall(List.of(4, 41, 42, 43, 44, 45))),
                createLotto(createBall(List.of(40, 41, 42, 43, 44, 45)))
        );
        LottoResultManager resultManager = new LottoResultManager(winningLotto, lottoList);

        Long totalPrizeMoney = resultManager.getTotalPrizeMoney();

        assertThat(totalPrizeMoney)
                .isEqualTo(prizeList.stream().reduce(0L, Long::sum));
    }
}