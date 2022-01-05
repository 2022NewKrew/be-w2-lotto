package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeTest {

    @DisplayName("번호 일치 정보를 토대로 당첨 등수를 가져온다.")
    @MethodSource("provideNumberMatchesInfo")
    @ParameterizedTest
    void getLottoRankTest(int numberOfMatches, boolean match, LottoPrize lottoPrize) {
        assertEquals(LottoPrize.getLottoRank(numberOfMatches,match), lottoPrize);
    }

    private static Stream<Arguments> provideNumberMatchesInfo() {
        return Stream.of(
                Arguments.of(6, true, LottoPrize.FIRST_PLACE),
                Arguments.of(6, false, LottoPrize.FIRST_PLACE),
                Arguments.of(5, true, LottoPrize.SECOND_PLACE),
                Arguments.of(5, false, LottoPrize.THIRD_PLACE),
                Arguments.of(4, true, LottoPrize.FOURTH_PLACE),
                Arguments.of(4, false, LottoPrize.FOURTH_PLACE),
                Arguments.of(3, true, LottoPrize.FIFTH_PLACE),
                Arguments.of(3, false, LottoPrize.FIFTH_PLACE),
                Arguments.of(2, true, LottoPrize.NOTHING),
                Arguments.of(2, false, LottoPrize.NOTHING),
                Arguments.of(1, true, LottoPrize.NOTHING),
                Arguments.of(1, false, LottoPrize.NOTHING),
                Arguments.of(0, true, LottoPrize.NOTHING),
                Arguments.of(0, false, LottoPrize.NOTHING)
        );
    }
}