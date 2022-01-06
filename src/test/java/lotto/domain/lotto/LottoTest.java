package lotto.domain.lotto;

import lotto.domain.player.PlayerLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호 테스트")
public class LottoTest {

    @Test
    @DisplayName("자동 플레이어 로또를 만들 수 있어야 한다.")
    public void canMakePlayerLottoAuto(){
        PlayerLotto lotto = new PlayerLotto();

        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource("getNumbers")
    @DisplayName("수동 번호로 플레이어 로또를 만들 수 있어야 한다.")
    public void canMakePlayerLottoManual(List<Integer> numbers){
        PlayerLotto lotto = new PlayerLotto(numbers);

        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("수동 번호의 개수는 6개여야 한다.")
    public void validateManualLottoSix(){
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // when
        Throwable thrown = catchThrowable(() -> new PlayerLotto(numbers));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 번호 입력 개수가 유효하지 않습니다.");
    }

    @Test
    @DisplayName("수동 번호의 개수는 중복 입력이 없어야 한다.")
    public void validateManualLottoDuplicate(){
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5);

        // when
        Throwable thrown = catchThrowable(() -> new PlayerLotto(numbers));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복 된 입력 번호가 있습니다.");
    }

    @Test
    @DisplayName("수동 번호는 1~45 사이어야 한다.")
    public void validateLottoMinMaxNumber(){
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        // when
        Throwable thrown = catchThrowable(() -> new PlayerLotto(numbers));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 1~45가 아닙니다.");
    }

    private static Stream<List<Integer>> getNumbers(){
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(1, 3, 5, 7, 8, 11)
        );
    }

}
