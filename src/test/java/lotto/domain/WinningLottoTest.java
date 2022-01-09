package lotto.domain;

import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("testLotto")
    @DisplayName("매치되는 숫자의 랭크를 반환한다.")
    void test1(Lotto lotto, Rank rank) {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getWinningLottoRank(lotto)).isEqualTo(rank);
    }
    private static Stream<Arguments> testLotto() {
        return Stream.of(
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 45)), Rank.THIRD),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 44, 45)), Rank.FOURTH),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 43, 44, 45)), Rank.FIFTH),
                Arguments.arguments(new Lotto(List.of(1, 2, 42, 43, 44, 45)), Rank.RAIN_CHECK),
                Arguments.arguments(new Lotto(List.of(1, 41, 42, 43, 44, 45)), Rank.RAIN_CHECK),
                Arguments.arguments(new Lotto(List.of(40, 41, 42, 43, 44, 45)), Rank.RAIN_CHECK)
        );
    }

}