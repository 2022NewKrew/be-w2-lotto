package be.w2.lotto.lottos;

import be.w2.lotto.exceptions.NonValidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("숫자의 String 으로 해당 번호의 로또 번호 가져오기 -> 잘못된 포맷의 String")
    void ofString_invalidFormat() {
        //Given
        String wrongFormatString = "건영이";

        //When, Then
        assertThrows(NumberFormatException.class, () -> LottoNumber.of(wrongFormatString));
    }

    @Test
    @DisplayName("숫자의 String 으로 해당 번호의 로또 번호 가져오기 -> Lotto 숫자 범위를 벗어남")
    void ofString_overRange() {
        //Given
        String wrongRangeString = String.valueOf(LottoNumber.MAX_NUM_IN_LOTTO + 1);

        //When, Then
        assertThrows(NonValidLottoNumberException.class, () -> LottoNumber.of(wrongRangeString));
    }

    @Test
    @DisplayName("숫자의 String 으로 해당 번호의 로또 번호 가져오기 -> 정상")
    void ofString() {
        //Given
        int lottoNumber = (LottoNumber.MAX_NUM_IN_LOTTO + LottoNumber.MIN_NUM_IN_LOTTO) / 2;
        String lottoNumberString = String.valueOf(lottoNumber);

        //When
        LottoNumber result = LottoNumber.of(lottoNumberString);

        //Then
        assertEquals(LottoNumber.of(lottoNumber), result);
    }

    @Test
    @DisplayName("숫자로 해당 로또 번호 가져오기 -> Lotto 숫자 범위를 벗어남")
    void ofInt_overRange() {
        //Given
        int numberOutOfRange = LottoNumber.MAX_NUM_IN_LOTTO + 100;

        //When, Then
        assertThrows(NonValidLottoNumberException.class, () -> LottoNumber.of(numberOutOfRange));
    }

    @Test
    @DisplayName("of -> of 에 같은 번호를 생성하면 같은 객체임을 증명")
    void ofInt_returnSameInstance() {
        //Given
        int number = (LottoNumber.MAX_NUM_IN_LOTTO + LottoNumber.MIN_NUM_IN_LOTTO) / 2;
        LottoNumber lottoNumber = LottoNumber.of(number);
        LottoNumber sameLottoNumber = LottoNumber.of(number);

        //When
        boolean result = lottoNumber == sameLottoNumber;

        //Then
        assertTrue(result);
    }

    @Test
    @DisplayName("compareTo -> 높은 번호와")
    void compareTo_withHigher() {
        //Given
        int numberOfTarget = (LottoNumber.MAX_NUM_IN_LOTTO + LottoNumber.MIN_NUM_IN_LOTTO) / 2;
        LottoNumber target = LottoNumber.of(numberOfTarget);
        LottoNumber higher = LottoNumber.of(numberOfTarget + 1);

        //When
        int result = target.compareTo(higher);

        //Then
        assertTrue(result < 0);
    }

    @Test
    @DisplayName("compareTo -> 같은 번호와")
    void compareTo_withSame() {
        //Given
        int numberOfTarget = (LottoNumber.MAX_NUM_IN_LOTTO + LottoNumber.MIN_NUM_IN_LOTTO) / 2;
        LottoNumber target = LottoNumber.of(numberOfTarget);
        LottoNumber same = LottoNumber.of(numberOfTarget);

        //When
        int result = target.compareTo(same);

        //Then
        assertTrue(result == 0);
    }

    @Test
    @DisplayName("compareTo -> 낮은 번호와")
    void compareTo_withLower() {
        //Given
        int numberOfTarget = (LottoNumber.MAX_NUM_IN_LOTTO + LottoNumber.MIN_NUM_IN_LOTTO) / 2;
        LottoNumber target = LottoNumber.of(numberOfTarget);
        LottoNumber lower = LottoNumber.of(numberOfTarget - 1);

        //When
        int result = target.compareTo(lower);

        //Then
        assertTrue(result > 0);
    }

    @Test
    @DisplayName("equals -> LottoNumber 클래스가 아닌것과")
    void equals_withAnotherClass() {
        //Given
        String anotherClass = "Gallix.kim";
        LottoNumber lottoNumber = LottoNumber.of((LottoNumber.MAX_NUM_IN_LOTTO + LottoNumber.MIN_NUM_IN_LOTTO) / 2);

        //When
        boolean result = lottoNumber.equals(anotherClass);

        //Then
        assertFalse(result);
    }

    @Test
    @DisplayName("equals -> LottoNumber && 다른 번호")
    void equals_withAnotherLottoNumber() {
        //Given
        LottoNumber lottoNumber = LottoNumber.of(LottoNumber.MAX_NUM_IN_LOTTO);
        LottoNumber anotherLottoNumber = LottoNumber.of(LottoNumber.MIN_NUM_IN_LOTTO);

        //When
        boolean result = lottoNumber.equals(anotherLottoNumber);

        //Then
        assertFalse(result);
    }

    @Test
    @DisplayName("equals -> 나 자신과")
    void equals_self() {
        //Given
        LottoNumber lottoNumber = LottoNumber.of(LottoNumber.MAX_NUM_IN_LOTTO);

        //When
        boolean result = lottoNumber.equals(lottoNumber);

        //Then
        assertTrue(result);
    }
}