package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoGameInfoTest {

    private static final int NO_MANUAL_LOTTO_QUANTITY = 0;

    @ParameterizedTest
    @MethodSource
    @DisplayName("입력한 금액의 최대 구입할 수 있는 로또 만큼 구입한다.")
    void testForPurchaseQuantityByInputMoney(int money, int expectedQuantity) {

        //when
        LottoGameInfo lottoGameInfo = new LottoGameInfo(money, NO_MANUAL_LOTTO_QUANTITY);

        //then
        assertThat(lottoGameInfo.getPurchaseQuantity()).isEqualTo(expectedQuantity);
    }

    private static Stream<Arguments> testForPurchaseQuantityByInputMoney() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(1999, 1),
                Arguments.of(2001, 2),
                Arguments.of(2500, 2),
                Arguments.of(100000, 100)
        );
    }

    @Test
    @DisplayName("입력한 금액이 1000원 보다 낮은 경우 예외가 발생한다.")
    void failToCreateLottoGameInfoWithNotEnoughMoney() {
        //when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoGameInfo(999, NO_MANUAL_LOTTO_QUANTITY))
                .withMessage("[에러] 구입 금액은 반드시 1000원 이상이어야 합니다.");
    }
}