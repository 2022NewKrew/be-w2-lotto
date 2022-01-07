package lotto.domain;

import lotto.exception.InvalidValueRangeException;
import lotto.util.Util;
import lotto.exception.InvalidListSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class LottoTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1"})
    @DisplayName("로또 내 숫자 개수가 정상범위인지 확인")
    void preventInvalidLottoNumberCount(String numbersString){
        List<Integer> numbers = Util.convStringToIntegerArraylist(numbersString, ",");
        InvalidListSizeException exception = assertThrows(InvalidListSizeException.class, ()-> new Lotto(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,333,4,5,6", "1,2,3,4,5,666", "-11,2,3,4,5,6"})
    @DisplayName("로또 내 숫자가 정상범위인지 확인")
    void preventInvalidLottoNumberRange(String numbersString){
        List<Integer> numbers = Util.convStringToIntegerArraylist(numbersString, ",");
        InvalidValueRangeException exception = assertThrows(InvalidValueRangeException.class, ()-> new Lotto(numbers));
    }
}