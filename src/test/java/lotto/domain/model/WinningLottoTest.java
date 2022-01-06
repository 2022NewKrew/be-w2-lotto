package lotto.domain.model;

import lotto.domain.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    private final static int BONUS_BALL = 7;
    private final static int EXPECTED_MATCH_NUMBER_COUNT = 6;
    private final static boolean EXPECTED_CONTAIN_BONUS_BALL = true;
    private final static List<Integer> WINNING_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private final static List<Integer> LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 7);

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("당첨 번호에 포함된 보너스 볼 번호는 예외가 발생해야한다.")
    void WinningLotto_InvalidBonusBall_ExceptionThrown(int bonusBall) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new WinningLotto(bonusBall, WINNING_LOTTO_NUMBERS))
                .hasMessage(ExceptionMessage.ERROR_DUPLICATE_BONUS_BALL.getMessage());
    }

    @Test
    @DisplayName("당첨된 횟수를 반환해야한다.")
    void getMatchNumberCount_When_LottoNumbers_And_WinningLottoNumbers_Given() {
        // given
        WinningLotto winningLotto = new WinningLotto(BONUS_BALL, WINNING_LOTTO_NUMBERS);

        // when
        final int matchCount = winningLotto.getMatchNumberCount(LOTTO_NUMBERS);

        // then
        assertThat(matchCount).isEqualTo(EXPECTED_MATCH_NUMBER_COUNT);
    }

    @Test
    @DisplayName("당첨 번호에 보너스 볼이 있다면 True를 반환한다.")
    void isContainBonusBall_ContainBonusBall_True() {
        // given
        WinningLotto winningLotto = new WinningLotto(BONUS_BALL, WINNING_LOTTO_NUMBERS);

        // when
        final boolean containBonusBall = winningLotto.isContainBonusBall(LOTTO_NUMBERS);

        // then
        assertThat(containBonusBall).isEqualTo(EXPECTED_CONTAIN_BONUS_BALL);
    }
}