package lotto.domain;

import static lotto.view.LottoOutputPrinterOnConsole.CHECK_LOTTO_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import lotto.exception.IllegalLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumberTest {

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
            Arguments.of(-1, CHECK_LOTTO_NUMBER_MESSAGE),
            Arguments.of(0, CHECK_LOTTO_NUMBER_MESSAGE),
            Arguments.of(46, CHECK_LOTTO_NUMBER_MESSAGE)
        );
    }

    static Stream<Arguments> compareTestParameters() {
        return Stream.of(
            Arguments.of(10, 15),
            Arguments.of(15, 15),
            Arguments.of(20, 15)
        );
    }

    @DisplayName("LottoNumber 생성 유효성 검사")
    @ParameterizedTest
    @MethodSource("invalidParameters")
    void invalidCreate(int num, String expectedMessage) {
        IllegalLottoNumberException iae = assertThrows(IllegalLottoNumberException.class,
            () -> new LottoNumber(num));
        assertEquals(iae.getMessage(), expectedMessage);
    }

    @DisplayName("두 로또 번호의 대소 비교 확인")
    @ParameterizedTest
    @MethodSource("compareTestParameters")
    void testCompareTo(int number1, int number2) {
        LottoNumber lottoNumber1 = new LottoNumber(number1);
        LottoNumber lottoNumber2 = new LottoNumber(number2);
        assertThat(lottoNumber1.compareTo(lottoNumber2)).isEqualTo(
            Integer.compare(lottoNumber1.getNumber(), lottoNumber2.getNumber()));
    }

    @DisplayName("두 로또 번호가 같은지 비교")
    @ParameterizedTest
    @MethodSource("compareTestParameters")
    void testEquals(int number1, int number2) {
        LottoNumber lottoNumber1 = new LottoNumber(number1);
        LottoNumber lottoNumber2 = new LottoNumber(number2);
        assertThat(lottoNumber1.equals(lottoNumber2)).isEqualTo(
            lottoNumber1.getNumber() == lottoNumber2.getNumber());
    }
}