package model.lotto;

import model.lotto.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoPrecondition 테스트")
class LottoPreconditionTest {

    @DisplayName("올바른 숫자들이 담긴 리스트를 가지고 LottoPrecondition.checkNumbers 메서드를 실행했을 때 예외를 던지지 않는다.")
    @ParameterizedTest
    @MethodSource("legalNumbers")
    void testLegalNumbers(List<LottoNumber> legalLottoNumbers) {
        //Give
        //When
        //Then
        assertThatCode(() -> LottoPrecondition.checkNumbers(legalLottoNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("중복된 숫자들이 담긴 리스트를 가지고 LottoPrecondition.checkNumbers 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("duplicatedNumbers")
    void testDuplicateNumbers(List<LottoNumber> illegalLottoNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> LottoPrecondition.checkNumbers(illegalLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자의 개수가 허용된 개수보다 작거나 큰 리스트를 가지고 LottoPrecondition.checkNumbers 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("outOfRangeNumbers")
    void testWrongLengthNumbers(List<LottoNumber> illegalLottoNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> LottoPrecondition.checkNumbers(illegalLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<LottoNumber>> legalNumbers() {
        return Stream.of(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)),
                Arrays.asList(new LottoNumber(1), new LottoNumber(5), new LottoNumber(9), new LottoNumber(13), new LottoNumber(17), new LottoNumber(21))
        );
    }

    static Stream<List<LottoNumber>> duplicatedNumbers() {
        return Stream.of(
                Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)),
                Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(13), new LottoNumber(17), new LottoNumber(21)),
                Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(5), new LottoNumber(5), new LottoNumber(6)),
                Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(5), new LottoNumber(5), new LottoNumber(5)),
                Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1))
        );
    }

    static Stream<List<LottoNumber>> outOfRangeNumbers() {
        return Stream.of(
                null,
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5)),
                Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(9), new LottoNumber(13), new LottoNumber(17), new LottoNumber(21), new LottoNumber(35))
        );
    }

}
