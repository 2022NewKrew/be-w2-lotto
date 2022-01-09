package lotto.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @DisplayName("맞춘 개수에 따라 알맞은 랭크를 반환하는지")
    @MethodSource("Ranks")
    void test1(int countOfMatch, Rank rank) {
        assertThat(Rank.valueOf(countOfMatch)).isEqualTo(rank);
    }

    private static Stream<Arguments> Ranks() {
        return Stream.of(
                Arguments.arguments(6, Rank.FIRST),
                Arguments.arguments(5, Rank.THIRD),
                Arguments.arguments(4, Rank.FOURTH),
                Arguments.arguments(3, Rank.FIFTH),
                Arguments.arguments(2, Rank.RAIN_CHECK),
                Arguments.arguments(1, Rank.RAIN_CHECK),
                Arguments.arguments(0, Rank.RAIN_CHECK)
        );
    }

}