package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void testSecondDescriptionIsValid() {
        LottoRank second = LottoRank.SECOND;
        String actualDescription = "5개 일치, 보너스 볼 일치 (30000000원)";
        assertEquals(second.getDescription(), actualDescription);
    }

    @ParameterizedTest
    @MethodSource("provideWinningCases")
    void testValueOfMatchEqualRank(int countOfMatch, boolean matchBonus, LottoRank rank) {
        assertEquals(LottoRank.valueOf(countOfMatch, matchBonus), rank);
    }

    static Stream<Arguments> provideWinningCases() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(2, true, LottoRank.NONE),
                Arguments.of(2, false, LottoRank.NONE),
                Arguments.of(1, true, LottoRank.NONE),
                Arguments.of(1, false, LottoRank.NONE),
                Arguments.of(0, false, LottoRank.NONE)
        );
    }
}
