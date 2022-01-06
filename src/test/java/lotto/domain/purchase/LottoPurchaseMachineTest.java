package lotto.domain.purchase;

import lotto.domain.player.PlayerLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 구매 테스트")
class LottoPurchaseMachineTest {

    @Test
    @DisplayName("자동 로또를 생성할 수 있어야 한다.")
    void purchaseAutoLotto() {
        // given
        // when
        PlayerLotto playerLotto = LottoPurchaseMachine.purchaseAutoLotto();

        //then
        assertThat(playerLotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("6개의 번호를 입력받으면 수동 로또를 생성할 수 있어야 한다.")
    void purchaseManualLotto() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        PlayerLotto playerLotto = LottoPurchaseMachine.purchaseManualLotto(numbers);

        //then
        assertThat(playerLotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력받은 숫자가 6개가 아니면 에러를 발생시킨다.")
    void purchaseManualLottoInvalidSize() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        Throwable thrown = catchThrowable(() -> LottoPurchaseMachine.purchaseManualLotto(numbers));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 번호 입력 개수가 유효하지 않습니다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 중복이라면 에러를 발생시킨다.")
    void purchaseManualLottoDuplicate() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when
        Throwable thrown = catchThrowable(() -> LottoPurchaseMachine.purchaseManualLotto(numbers));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복 된 입력 번호가 있습니다.");
    }
}