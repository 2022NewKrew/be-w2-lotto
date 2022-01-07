package business.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {

    @ParameterizedTest
    @MethodSource("provideRankAndMatchCountAndBonusNumberMatched")
    void valueOf_ValidParameter_ReturnsCorrectRank(Rank expected, MatchCount matchCount,
        BonusNumberMatched bonusNumberMatched) {
        assertThat(Rank.valueOf(matchCount, bonusNumberMatched)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideRankAndPrize")
    void getPrize_Invoked_ReturnsCorrectObject(Rank rank, Money expected) {
        assertThat(rank.getPrize()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideRankAndDescription")
    void getDescription_Invoked_ReturnsCorrectObject(Rank rank, String expected) {
        assertThat(rank.getDescription()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRankAndMatchCountAndBonusNumberMatched() {
        return Stream.of(Arguments.of(Rank.MISS, MatchCount.from(0), BonusNumberMatched.from(true)),
            Arguments.of(Rank.MISS, MatchCount.from(0), BonusNumberMatched.from(false)),
            Arguments.of(Rank.MISS, MatchCount.from(1), BonusNumberMatched.from(true)),
            Arguments.of(Rank.MISS, MatchCount.from(1), BonusNumberMatched.from(false)),
            Arguments.of(Rank.MISS, MatchCount.from(2), BonusNumberMatched.from(true)),
            Arguments.of(Rank.MISS, MatchCount.from(2), BonusNumberMatched.from(false)),
            Arguments.of(Rank.FIFTH, MatchCount.from(3), BonusNumberMatched.from(true)),
            Arguments.of(Rank.FIFTH, MatchCount.from(3), BonusNumberMatched.from(false)),
            Arguments.of(Rank.FOURTH, MatchCount.from(4), BonusNumberMatched.from(true)),
            Arguments.of(Rank.FOURTH, MatchCount.from(4), BonusNumberMatched.from(false)),
            Arguments.of(Rank.SECOND, MatchCount.from(5), BonusNumberMatched.from(true)),
            Arguments.of(Rank.THIRD, MatchCount.from(5), BonusNumberMatched.from(false)),
            Arguments.of(Rank.FIRST, MatchCount.from(6), BonusNumberMatched.from(false)));
    }

    private static Stream<Arguments> provideRankAndPrize() {
        return Stream.of(Arguments.of(Rank.FIRST, new Money(2_000_000_000L)),
            Arguments.of(Rank.SECOND, new Money(30_000_000L)),
            Arguments.of(Rank.THIRD, new Money(1_500_000L)),
            Arguments.of(Rank.FOURTH, new Money(50_000L)),
            Arguments.of(Rank.FIFTH, new Money(5_000L)), Arguments.of(Rank.MISS, new Money(0L)));
    }

    private static Stream<Arguments> provideRankAndDescription() {
        return Stream.of(Arguments.of(Rank.FIRST, "6개 일치 (2000000000원)"),
            Arguments.of(Rank.SECOND, "5개 일치, 보너스 볼 일치(30000000원)"),
            Arguments.of(Rank.THIRD, "5개 일치 (1500000원)"),
            Arguments.of(Rank.FOURTH, "4개 일치 (50000원)"), Arguments.of(Rank.FIFTH, "3개 일치 (5000원)"),
            Arguments.of(Rank.MISS, "3개 미만 일치 (0원)"));
    }
}
