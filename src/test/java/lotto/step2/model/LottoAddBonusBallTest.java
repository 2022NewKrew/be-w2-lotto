package lotto.step2.model;

import lotto.step1.model.LottoNumbers;
import lotto.step1.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LottoAddBonusBallTest {

    @Test
    @DisplayName("모든 로또 번호에 대해서 보너스 볼을 추가한 당첨 확인을 성공적으로 수행하는 테스트")
    void confirmTheWin() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final LottoNumbers lottoNumbers1 = createLottoNumbersAddBonusBall(List.of(1, 2, 3, 4, 5, 6), LottoResult.UNIDENTIFIED);
        final LottoNumbers lottoNumbers2 = createLottoNumbersAddBonusBall(List.of(1, 2, 3, 4, 5, 7), LottoResult.UNIDENTIFIED);

        final LottoAddBonusBall lotto = createLottoAddBonusBall(List.of(lottoNumbers1, lottoNumbers2));

        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusBall = 7;
        // when
        lotto.confirmTheWin(winningNumbers, bonusBall);

        // then
        for (LottoNumbers actualLottoNumbers : lotto.getPurchasedLottoNumbersList()) {
            assertNotEquals(actualLottoNumbers.getResult(), LottoResult.UNIDENTIFIED);
        }
    }

    private LottoAddBonusBall createLottoAddBonusBall(List<LottoNumbers> lottoNumbers) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<LottoAddBonusBall> lottoConstructor = LottoAddBonusBall.class.getDeclaredConstructor(List.class);
        lottoConstructor.setAccessible(true);
        return lottoConstructor.newInstance(lottoNumbers);
    }

    private LottoNumbers createLottoNumbersAddBonusBall(List<Integer> numbers, LottoResult lottoResult) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<LottoNumbersAddBonusBall> lottoNumbersConstructor = LottoNumbersAddBonusBall.class.getDeclaredConstructor(List.class, LottoResult.class);
        lottoNumbersConstructor.setAccessible(true);
        return lottoNumbersConstructor.newInstance(numbers, lottoResult);
    }

}