package lotto.step1.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("모든 로또 번호에 대해서 당첨 확인을 성공적으로 수행하는 테스트")
    void confirmTheWin() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final LottoNumbers lottoNumbers1 = createLottoNumber(List.of(1, 2, 3, 4, 5, 6), LottoResult.UNIDENTIFIED);
        final LottoNumbers lottoNumbers2 = createLottoNumber(List.of(7, 8, 9, 10, 11, 12), LottoResult.UNIDENTIFIED);

        final Lotto lotto = createLotto(List.of(lottoNumbers1, lottoNumbers2));

        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        lotto.confirmTheWin(winningNumbers);

        // then
        for (LottoNumbers actualLottoNumbers : lotto.getPurchasedLottoNumbersList()) {
            assertNotEquals(actualLottoNumbers.getResult(), LottoResult.UNIDENTIFIED);
        }
    }

    @Test
    @DisplayName("모든 로또 번호들의 상금 총액이 성공적으로 반환하는 테스트")
    void getPrizeMoney() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        final LottoNumbers lottoNumbers1 = createLottoNumber(Collections.emptyList(), LottoResult.FIRST_PLACE);
        final LottoNumbers lottoNumbers2 = createLottoNumber(Collections.emptyList(), LottoResult.SECOND_PLACE);

        final Lotto lotto = createLotto(List.of(lottoNumbers1, lottoNumbers2));

        // when
        final int totalPrizeMoney = lotto.getPrizeMoney();

        // then
        final int expectedTotalPrizeMoney = LottoResult.FIRST_PLACE.getPrizeMoney() + LottoResult.SECOND_PLACE.getPrizeMoney();
        assertEquals(totalPrizeMoney, expectedTotalPrizeMoney);
    }

    @Test
    @DisplayName("생성시 만들어진 로또 번호들이 성공적으로 반환되는 테스트")
    void getPurchasedLottoNumbersList() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final LottoNumbers lottoNumbers1 = createLottoNumber(List.of(1, 2, 3, 4, 5, 7), LottoResult.UNIDENTIFIED);
        final LottoNumbers lottoNumbers2 = createLottoNumber(List.of(8, 9, 10, 11, 12, 13), LottoResult.UNIDENTIFIED);

        final List<LottoNumbers> lottoNumbersList = List.of(lottoNumbers1, lottoNumbers2);

        final Lotto lotto = createLotto(lottoNumbersList);

        // when
        final List<LottoNumbers> actualLottoNumbersList = lotto.getPurchasedLottoNumbersList();

        // then
        assertIterableEquals(actualLottoNumbersList, lottoNumbersList);
    }

    @Test
    @DisplayName("모든 로또 번호들에 대한 당첨결과를 성공적으로 반환하는 테스트")
    void getLottoResults() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final LottoNumbers lottoNumbers1 = createLottoNumber(Collections.emptyList(), LottoResult.FIRST_PLACE);
        final LottoNumbers lottoNumbers2 = createLottoNumber(Collections.emptyList(), LottoResult.SECOND_PLACE);
        final LottoNumbers lottoNumbers3 = createLottoNumber(Collections.emptyList(), LottoResult.SECOND_PLACE);
        final LottoNumbers lottoNumbers4 = createLottoNumber(Collections.emptyList(), LottoResult.UNWINNABLE);

        final Lotto lotto = createLotto(List.of(lottoNumbers1, lottoNumbers2, lottoNumbers3, lottoNumbers4));

        // when
        final Map<LottoResult, Integer> lottoResults = lotto.getLottoResults();

        // then
        final int numOfFirstPlace = lottoResults.get(LottoResult.FIRST_PLACE);
        assertEquals(numOfFirstPlace, 1);

        final int numOfSecondPlace = lottoResults.get(LottoResult.SECOND_PLACE);
        assertEquals(numOfSecondPlace, 2);

        final Integer numOfThirdPlace = lottoResults.get(LottoResult.THIRD_PLACE);
        assertNull(numOfThirdPlace);

        final Integer numOfFourthPlace = lottoResults.get(LottoResult.FOURTH_PLACE);
        assertNull(numOfFourthPlace);

        final int numOfSUnwinnable = lottoResults.get(LottoResult.UNWINNABLE);
        assertEquals(numOfSUnwinnable, 1);
    }

    private Lotto createLotto(List<LottoNumbers> lottoNumbers) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<Lotto> lottoConstructor = Lotto.class.getDeclaredConstructor(List.class);
        lottoConstructor.setAccessible(true);
        return lottoConstructor.newInstance(lottoNumbers);
    }


    private LottoNumbers createLottoNumber(List<Integer> numbers, LottoResult lottoResult) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<LottoNumbers> lottoNumbersConstructor = LottoNumbers.class.getDeclaredConstructor(List.class, LottoResult.class);
        lottoNumbersConstructor.setAccessible(true);
        return lottoNumbersConstructor.newInstance(numbers, lottoResult);
    }
}