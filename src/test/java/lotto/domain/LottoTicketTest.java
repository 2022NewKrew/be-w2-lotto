package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {
    private static final Set<Integer> winnerNumber = Set.of(1, 2, 3, 4, 5, 6);
    private static final int bonusBall = 45;

    @DisplayName("등수 계산 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    void matchWithWinnerNumber(Set<Integer> pickedNumber, Prize expectedPrize) {
        LottoTicket ticket = new LottoTicket(pickedNumber);
        assertThat(ticket.matchWithWinnerNumber(winnerNumber, bonusBall)).isEqualTo(expectedPrize);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                // without bonus
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), Prize.FIRST),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 36), Prize.THIRD),
                Arguments.of(Set.of(1, 2, 3, 4, 35, 36), Prize.FOURTH),
                Arguments.of(Set.of(1, 2, 3, 34, 35, 36), Prize.FIFTH),
                Arguments.of(Set.of(1, 2, 33, 34, 35, 36), Prize.SIXTH),
                Arguments.of(Set.of(1, 32, 33, 34, 35, 36), Prize.SEVENTH),
                Arguments.of(Set.of(31, 32, 33, 34, 35, 36), Prize.NOTHING),

                // with bonus
                Arguments.of(Set.of(1, 2, 3, 4, 5, bonusBall), Prize.SECOND),
                Arguments.of(Set.of(1, 2, 3, 4, 35, bonusBall), Prize.FOURTH),
                Arguments.of(Set.of(1, 2, 3, 34, 35, bonusBall), Prize.FIFTH),
                Arguments.of(Set.of(1, 2, 33, 34, 35, bonusBall), Prize.SIXTH),
                Arguments.of(Set.of(1, 32, 33, 34, 35, bonusBall), Prize.SEVENTH),
                Arguments.of(Set.of(31, 32, 33, 34, 35, bonusBall), Prize.NOTHING)
        );
    }
}