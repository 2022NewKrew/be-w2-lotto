package lotto.step2.model;

import lotto.step1.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersAddBonusBallTest {

    @Test
    @DisplayName("로또 당첨 결과가 보너스 등수인 테스트")
    void confirmTheWinAddBonusBall() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusBall = 7;

        final LottoNumbersAddBonusBall lottoNumbersAddBonusBall = createLottoNumbersAddBonusBall(numbers, LottoResult.UNIDENTIFIED);

        // when
        lottoNumbersAddBonusBall.confirmTheWinAddBonusBall(winningNumbers, bonusBall);

        // then
        assertEquals(lottoNumbersAddBonusBall.getResult(), LottoResult.BONUS_PLACE);
    }

    private LottoNumbersAddBonusBall createLottoNumbersAddBonusBall(List<Integer> numbers, LottoResult lottoResult) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<LottoNumbersAddBonusBall> lottoNumbersConstructor = LottoNumbersAddBonusBall.class.getDeclaredConstructor(List.class, LottoResult.class);
        lottoNumbersConstructor.setAccessible(true);
        return lottoNumbersConstructor.newInstance(numbers, lottoResult);
    }
}