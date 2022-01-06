package be.w2.lotto.lottos;

import be.w2.lotto.exceptions.LottoNumberDuplicationFoundedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("중복된 숫자들로 로또 생성 -> 어우 그럼 예외 던져야제")
    void constructor_duplicatedNumber() {
        //Given
        List<Integer> numbersOfLotto = Arrays.asList(16, 16, 17, 18, 19, 20);
        List<LottoNumber> lottoNumbers = getLottoNumbersBy(numbersOfLotto);

        //When, Then
        assertThrows(LottoNumberDuplicationFoundedException.class, () -> new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("해당 번호를 포함하고 있는지 확인 -> 포함하지 않음")
    void isContain_notContain() {
        //Given
        int numberWhichIsNotInLotto = 10;
        LottoNumber lottoNumberNotInLotto = LottoNumber.of(numberWhichIsNotInLotto);
        List<Integer> numbersOfLotto = Arrays.asList(1, 5, 29, 32, 36, 44);
        Lotto lotto = getInstance(numbersOfLotto);

        //When
        boolean result = lotto.isContain(lottoNumberNotInLotto);

        //Then
        assertFalse(result);
    }

    @Test
    @DisplayName("해당 번호를 포함하고 있는지 확인 -> 포함")
    void isContain_contain() {
        //Given
        int numberWhichIsInLotto = 15;
        LottoNumber lottoNumberInLotto = LottoNumber.of(15);
        List<Integer> numberOfLotto = Arrays.asList(11, numberWhichIsInLotto, 24, 32, 33, 44);
        Lotto lotto = getInstance(numberOfLotto);

        //When
        boolean result = lotto.isContain(lottoNumberInLotto);

        //Then
        assertTrue(result);
    }

    public static Lotto getInstance(List<Integer> numbersOfLotto) {
        return new Lotto(getLottoNumbersBy(numbersOfLotto));
    }

    private static List<LottoNumber> getLottoNumbersBy(List<Integer> numbersOfLotto) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(Integer number: numbersOfLotto) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        return lottoNumbers;
    }
}