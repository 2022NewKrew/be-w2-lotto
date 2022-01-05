package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoRankTest {

    @DisplayName("당첨 개수에 맞는 결과가 반환되야 한다.")
    @ParameterizedTest
    @MethodSource("provideLottoResultAndCountOfMatches")
    void parseResult(int countOfMatches, boolean isMatchBonusNumber, LottoRank expected) {
        assertThat(LottoRank.parseResult(countOfMatches, isMatchBonusNumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoResultAndCountOfMatches() {
        return Stream.of(
                arguments(6, false, LottoRank.FIRST),
                arguments(5, true, LottoRank.SECOND),
                arguments(5, false, LottoRank.THIRD),
                arguments(4, false, LottoRank.FOURTH),
                arguments(4, true, LottoRank.FOURTH),
                arguments(3, false, LottoRank.FIFTH),
                arguments(3, true, LottoRank.FIFTH)
        );
    }
}