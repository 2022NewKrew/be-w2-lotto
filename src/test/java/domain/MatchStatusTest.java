package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchStatusTest {

    @DisplayName("올바른 당첨 상태 객체가 반환되는지 검증")
    @Test
    void isCorrectMatchingStatusReturn() {
        List<MatchStatus> matchStatusList = List.of(
                MatchStatus.getMatchingStatus(2, false),
                MatchStatus.getMatchingStatus(3, false),
                MatchStatus.getMatchingStatus(4, false),
                MatchStatus.getMatchingStatus(5, false),
                MatchStatus.getMatchingStatus(5, true),
                MatchStatus.getMatchingStatus(6, false)
        );

        assertThat(matchStatusList)
                .containsExactly(
                        MatchStatus.NOTHING, MatchStatus.THREE_MATCHES, MatchStatus.FOUR_MATCHES,
                        MatchStatus.FIVE_MATCHES, MatchStatus.FIVE_MATCHES_AND_BONUS, MatchStatus.ALL_MATCHES
                );
    }

    @DisplayName("유효하지 않은 입력 시 반환값 검증")
    @Test
    void isInvalidMatchingStatusReturn() {
        List<MatchStatus> invalidMatchList = List.of(
                MatchStatus.getMatchingStatus(6, true),
                MatchStatus.getMatchingStatus(-1, false),
                MatchStatus.getMatchingStatus(-1, true),
                MatchStatus.getMatchingStatus(7, true)
        );

        assertThat(invalidMatchList)
                .containsAll(Collections.singleton(MatchStatus.INVALID));
    }
}