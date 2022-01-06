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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConditionCheckTest {

    @DisplayName("양수 true, 아니면 false")
    @Test
    void isPositiveInteger() {
        assertThat(ConditionCheck.isPositiveInteger(1)).isTrue();
        assertThat(ConditionCheck.isPositiveInteger(0)).isFalse();
        assertThat(ConditionCheck.isPositiveInteger(-1)).isFalse();
    }

    @DisplayName("음수 true, 아니면 false")
    @Test
    void isNegativeInteger() {
        assertThat(ConditionCheck.isNegativeInteger(1)).isFalse();
        assertThat(ConditionCheck.isNegativeInteger(0)).isFalse();
        assertThat(ConditionCheck.isNegativeInteger(-1)).isTrue();
    }

    @DisplayName("로또 번호 범위 내에 있으면서 중복없이 로또 번호 개수만큼 리스트에 있어야 true")
    @MethodSource("provideLottoNumbers")
    @ParameterizedTest
    void isValidLottoNumber(List<Integer> numbers, boolean value) {
        assertThat(ConditionCheck.isValidLottoNumber(numbers)).isEqualTo(value);
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
        assertThat(ConditionCheck.isLottoNumber(Lotto.MIN_LOTTO_NUMBER.getValue())).isTrue();
        assertThat(ConditionCheck.isLottoNumber(Lotto.MIN_LOTTO_NUMBER.getValue()-1)).isFalse();
        assertThat(ConditionCheck.isLottoNumber(Lotto.MAX_LOTTO_NUMBER.getValue())).isTrue();
        assertThat(ConditionCheck.isLottoNumber(Lotto.MAX_LOTTO_NUMBER.getValue()+1)).isFalse();
    }

    @DisplayName("중복없이 로또번호 개수만큼 리스트에 있으면 true")
    @MethodSource("provideNumbers")
    @ParameterizedTest
    void isDistinctLottoNumbers(List<Integer> numbers, boolean value) {
        assertThat(ConditionCheck.isDistinctLottoNumbers(numbers)).isEqualTo(value);
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