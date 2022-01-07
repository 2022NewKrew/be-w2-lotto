package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class LottoResultTest {
    private static final WinningLotto winningLotto = WinningLotto.create(createBallList(List.of(1, 2, 3, 4, 5, 6)), Ball.create(7));

    private static final List<Lotto> lottoList = List.of(
            Lotto.create(createBallList(List.of(4, 5, 6, 1, 2, 3))),
            Lotto.create(createBallList(List.of(4, 5, 6, 1, 2, 45))),
            Lotto.create(createBallList(List.of(4, 5, 6, 1, 2, 7))),
            Lotto.create(createBallList(List.of(4, 5, 6, 1, 44, 45))),
            Lotto.create(createBallList(List.of(4, 5, 6, 43, 44, 45))),
            Lotto.create(createBallList(List.of(4, 41, 42, 43, 44, 45))),
            Lotto.create(createBallList(List.of(40, 41, 42, 43, 44, 45)))
    );
    private final List<Long> prizeList = List.of(5000L, 50000L, 1500000L, 30000000L, 2000000000L);

    private static List<Ball> createBallList(List<Integer> list) {
        return list.stream()
                .map(Ball::create)
                .collect(Collectors.toList());
    }

    @DisplayName("당첨 결과가 올바른지 검증")
    @Test
    void isResultCorrect() {
        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);
        Map<MatchStatus, Integer> result = new EnumMap<>(MatchStatus.class);

        for (var status: MatchStatus.values()) {
            result.put(status, lottoResult.getCountByMatchResult(status));
        }

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
        LottoResult resultManager = new LottoResult(winningLotto, lottoList);

        Long totalPrizeMoney = resultManager.getTotalPrizeMoney();

        assertThat(totalPrizeMoney)
                .isEqualTo(prizeList.stream().reduce(0L, Long::sum));
    }
}