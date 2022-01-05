package valid;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConditionCheckTest {

    @DisplayName("양수 true, 아니면 false")
    @Test
    void isPositiveInteger() {
        assertTrue(ConditionCheck.isPositiveInteger(1));
        assertFalse(ConditionCheck.isPositiveInteger(0));
        assertFalse(ConditionCheck.isPositiveInteger(-1));
    }

    @DisplayName("음수 true, 아니면 false")
    @Test
    void isNegativeInteger() {
        assertFalse(ConditionCheck.isNegativeInteger(1));
        assertFalse(ConditionCheck.isNegativeInteger(0));
        assertTrue(ConditionCheck.isNegativeInteger(-1));
    }

    @DisplayName("로또 번호 범위 내에 있으면서 중복없이 로또 번호 개수만큼 리스트에 있어야 true")
    @MethodSource("provideLottoNumbers")
    @ParameterizedTest
    void isValidLottoNumber(List<Integer> numbers, boolean value) {
        assertEquals(ConditionCheck.isValidLottoNumber(numbers), value);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                //개수는 맞고 값도 맞는 상황
                Arguments.of(Arrays.asList(1,2,3,4,5,6), true),
                Arguments.of(Arrays.asList(1,2,3,4,5,5),false),

                //중복 없고 값은 맞는 상황
                Arguments.of(Arrays.asList(1,2,3,4,5),false),
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7),false),

                //중복없고 개수는 맞는 상황
                Arguments.of(Arrays.asList(Lotto.MIN_LOTTO_NUMBER.getValue(),2,3,4,5,6),true),
                Arguments.of(Arrays.asList(1,2,3,4,5,Lotto.MAX_LOTTO_NUMBER.getValue()), true),
                Arguments.of(Arrays.asList(Lotto.MIN_LOTTO_NUMBER.getValue()-1,2,3,4,5,6),false),
                Arguments.of(Arrays.asList(1,2,3,4,5,Lotto.MAX_LOTTO_NUMBER.getValue()+1), false),

                //중복제거 후 로또 개수만큼인 것 체크
                Arguments.of(Arrays.asList(1,2,3,4,5,5,6),false),
                Arguments.of(Arrays.asList(1,2,3,4,5,5,47),false)
        );
    }

    @DisplayName("로또 번호 범위 내에 있으면 true")
    @Test
    void isLottoNumber() {
        assertTrue(ConditionCheck.isLottoNumber(Lotto.MIN_LOTTO_NUMBER.getValue()));
        assertFalse(ConditionCheck.isLottoNumber(Lotto.MIN_LOTTO_NUMBER.getValue()-1));
        assertTrue(ConditionCheck.isLottoNumber(Lotto.MAX_LOTTO_NUMBER.getValue()));
        assertFalse(ConditionCheck.isLottoNumber(Lotto.MAX_LOTTO_NUMBER.getValue()+1));
    }

    @DisplayName("중복없이 로또번호 개수만큼 리스트에 있으면 true")
    @MethodSource("provideNumbers")
    @ParameterizedTest
    void isDistinctLottoNumbers(List<Integer> numbers, boolean value) {
        assertEquals(ConditionCheck.isDistinctLottoNumbers(numbers), value);
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), true),
                Arguments.of(Arrays.asList(1,2,3,4,5),false),
                Arguments.of(Arrays.asList(1,2,3,4,5,5),false),
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7),false),
                Arguments.of(Arrays.asList(-1,2,3,4,5,6),true), //값이 체크가 아닌 개수만 체크함
                Arguments.of(Arrays.asList(1,2,3,4,5,5,6),false) //중복제거 후 로또 개수만큼인 것 체크
        );
    }
}