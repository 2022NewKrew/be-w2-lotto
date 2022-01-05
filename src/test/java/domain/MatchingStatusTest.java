package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchingStatusTest {

    @DisplayName("올바른 당첨 상태 객체가 반환되는지 검증")
    @Test
    void isCorrectMatchingStatusReturn() {
        List<MatchingStatus> matchingStatusList = List.of(
                MatchingStatus.getMatchingStatus(2, false),
                MatchingStatus.getMatchingStatus(3, false),
                MatchingStatus.getMatchingStatus(4, false),
                MatchingStatus.getMatchingStatus(5, false),
                MatchingStatus.getMatchingStatus(5, true),
                MatchingStatus.getMatchingStatus(6, false)
        );

        assertThat(matchingStatusList)
                .containsExactly(
                        MatchingStatus.NOTHING, MatchingStatus.THREE_MATCHES, MatchingStatus.FOUR_MATCHES,
                        MatchingStatus.FIVE_MATCHES, MatchingStatus.FIVE_MATCHES_AND_BONUS, MatchingStatus.ALL_MATCHES
                );
    }

    @DisplayName("유효하지 않은 입력 시 반환값 검증")
    @Test
    void isInvalidMatchingStatusReturn() {
        List<MatchingStatus> invalidMatchList = List.of(
                MatchingStatus.getMatchingStatus(6, true),
                MatchingStatus.getMatchingStatus(-1, false),
                MatchingStatus.getMatchingStatus(-1, true),
                MatchingStatus.getMatchingStatus(7, true)
        );

        assertThat(invalidMatchList)
                .containsAll(Collections.singleton(MatchingStatus.INVALID));
    }
}