package lotto.step1.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 당첨 결과가 1등인 테스트")
    void confirmTheWin1() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        final LottoNumbers lottoNumbers = createLottoNumber(numbers, LottoResult.UNIDENTIFIED);

        // when
        lottoNumbers.confirmTheWin(winningNumbers);

        // then
        assertEquals(lottoNumbers.getResult(), LottoResult.FIRST_PLACE);
    }

    @Test
    @DisplayName("로또 당첨 결과가 2등인 테스트")
    void confirmTheWin2() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);

        final LottoNumbers lottoNumbers = createLottoNumber(numbers, LottoResult.UNIDENTIFIED);

        // when
        lottoNumbers.confirmTheWin(winningNumbers);

        // then
        assertEquals(lottoNumbers.getResult(), LottoResult.SECOND_PLACE);
    }

    @Test
    @DisplayName("로또 당첨 결과가 3등인 테스트")
    void confirmTheWin3() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 7, 8);

        final LottoNumbers lottoNumbers = createLottoNumber(numbers, LottoResult.UNIDENTIFIED);

        // when
        lottoNumbers.confirmTheWin(winningNumbers);

        // then
        assertEquals(lottoNumbers.getResult(), LottoResult.THIRD_PLACE);
    }


    @Test
    @DisplayName("로또 당첨 결과가 4등인 테스트")
    void confirmTheWin4() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);

        final LottoNumbers lottoNumbers = createLottoNumber(numbers, LottoResult.UNIDENTIFIED);

        // when
        lottoNumbers.confirmTheWin(winningNumbers);

        // then
        assertEquals(lottoNumbers.getResult(), LottoResult.FOURTH_PLACE);
    }

    @Test
    @DisplayName("로또 당첨 결과가 미당첨인 테스트")
    void confirmTheWin_UnWinnable() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> winningNumbers = List.of(1, 2, 7, 8, 9, 10);

        final LottoNumbers lottoNumbers = createLottoNumber(numbers, LottoResult.UNIDENTIFIED);

        // when
        lottoNumbers.confirmTheWin(winningNumbers);

        // then
        assertEquals(lottoNumbers.getResult(), LottoResult.UNWINNABLE);
    }

    @Test
    @DisplayName("등수에 맞는 상금 결과가 성공적으로 반환되는 테스트")
    void getPrizeMoney() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final LottoNumbers lottoNumbers = createLottoNumber(Collections.emptyList(), LottoResult.FIRST_PLACE);

        // when
        final int prizeMoney = lottoNumbers.getPrizeMoney();

        // then
        assertEquals(prizeMoney, LottoResult.FIRST_PLACE.getPrizeMoney());
    }

    @Test
    @DisplayName("'1,2,3,4,5,6'출력 형식에 맞게 성공적으로 출력하는 테스트")
    void toNumbersListStr() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final LottoNumbers lottoNumbers = createLottoNumber(List.of(1, 2, 3, 4, 5, 6), LottoResult.UNIDENTIFIED);

        // when
        final String result = lottoNumbers.toNumbersListStr();

        // then
        assertEquals(result, "1,2,3,4,5,6");
    }

    @Test
    @DisplayName("'[1,2,3,4,5,6]'출력 형식에 맞게 성공적으로 출력하는 테스트")
    void toStringTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final LottoNumbers lottoNumbers = createLottoNumber(List.of(1, 2, 3, 4, 5, 6), LottoResult.UNIDENTIFIED);

        // when
        final String result = lottoNumbers.toString();

        // then
        assertEquals(result, "[1,2,3,4,5,6]");
    }

    private LottoNumbers createLottoNumber(List<Integer> numbers, LottoResult lottoResult) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<LottoNumbers> lottoNumbersConstructor = LottoNumbers.class.getDeclaredConstructor(List.class, LottoResult.class);
        lottoNumbersConstructor.setAccessible(true);
        return lottoNumbersConstructor.newInstance(numbers, lottoResult);
    }

}