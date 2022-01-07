package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static util.LottoConst.LOTTO_PRICE;

class LottoGameInfoTest {

    private static final List<LottoOrder> EMPTY_MANUAL_LOTTO_ORDER = Collections.emptyList();

    @ParameterizedTest
    @MethodSource
    @DisplayName("입력한 금액의 최대 구입할 수 있는 로또 만큼 구입한다.")
    void testForPurchaseQuantityByInputMoney(int money, int expectedQuantity) {
        //when
        LottoGameInfo lottoGameInfo = new LottoGameInfo(money, EMPTY_MANUAL_LOTTO_ORDER);

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
                .isThrownBy(() -> new LottoGameInfo(999, EMPTY_MANUAL_LOTTO_ORDER))
                .withMessage("[에러] 구입 금액은 반드시 1000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("입력한 금액이 음수인 경우 예외가 발생한다.")
    void failToCreateLottoGameInfoWithNegativeNumber() {
        //when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoGameInfo(-1, EMPTY_MANUAL_LOTTO_ORDER))
                .withMessage("[에러] 음수 값을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("입력한 금액보다 많은 로또를 구매하려하면 예외가 발생한다.")
    void failToCreateLottoGameInfoWithExceedPurchaseLimit() {
        //given
        LottoOrder lottoOrder = new LottoOrder(List.of(1,2,3,4,5,6));
        List<LottoOrder> exceedLimitOrder = List.of(lottoOrder, lottoOrder);
        int money = LOTTO_PRICE * 2 - 1;

        //when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoGameInfo(money, exceedLimitOrder))
                .withMessage("[에러] 입력한 금액보다 많은 로또를 구매할 수 없습니다.");
    }
}