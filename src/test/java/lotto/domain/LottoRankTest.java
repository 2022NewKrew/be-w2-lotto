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
    void parseResult(int countOfMatches, LottoRank expected) {
        assertThat(LottoRank.parseResult(countOfMatches)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoResultAndCountOfMatches() {
        return Stream.of(
                arguments(6, LottoRank.FIRST),
                arguments(5, LottoRank.SECOND),
                arguments(4, LottoRank.THIRD),
                arguments(3, LottoRank.FOURTH)
        );
    }
}