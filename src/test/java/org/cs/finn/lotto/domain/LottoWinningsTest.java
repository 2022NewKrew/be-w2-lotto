package org.cs.finn.lotto.domain;

import org.assertj.core.api.Assertions;
import org.cs.finn.lotto.domain.lotto.LottoNumber;
import org.cs.finn.lotto.domain.lotto.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoWinningsTest {

    @ParameterizedTest
    @MethodSource("argsForConstructorNullFailure")
    @DisplayName("생성자에 null이 전달되면 예외를 발생시킨다")
    public void testConstructorNullFailure(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        Assertions.assertThatThrownBy(() -> new LottoWinnings(lottoNumbers, bonusNumber))
                .isInstanceOf(NullPointerException.class);
    }

    public static Stream<Arguments> argsForConstructorNullFailure() {
        return Stream.of(
                Arguments.of(null, new LottoNumber(4)),
                Arguments.of(new LottoNumbers(new String[]{ "1", "2", "3", "4", "5", "6" }), null)
                );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorLottoNumbersContainBonusNumberFailure")
    @DisplayName("생성자에 LottoNumbers 내 존재하는 번호가 bonusNumber에 전달되면 예외를 발생시킨다")
    public void testConstructorLottoNumbersContainBonusNumberFailure(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        Assertions.assertThatThrownBy(() -> new LottoWinnings(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForConstructorLottoNumbersContainBonusNumberFailure() {
        final LottoNumbers lottoNumbers = new LottoNumbers(new String[]{ "1", "2", "3", "4", "5", "6" });
        return Stream.of(
                Arguments.of(lottoNumbers, new LottoNumber(1)),
                Arguments.of(lottoNumbers, new LottoNumber(2)),
                Arguments.of(lottoNumbers, new LottoNumber(3)),
                Arguments.of(lottoNumbers, new LottoNumber(4)),
                Arguments.of(lottoNumbers, new LottoNumber(5)),
                Arguments.of(lottoNumbers, new LottoNumber(6))
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorSuccess")
    @DisplayName("생성자에 중복 없이 번호 6 + 1개가 전달되면 정상적으로 객체를 생성한다")
    public void testConstructorSuccess(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        assertThatNoException().isThrownBy(() -> new LottoWinnings(lottoNumbers, bonusNumber));
    }

    public static Stream<Arguments> argsForConstructorSuccess() {
        return Stream.of(
                Arguments.of(new LottoNumbers(new String[]{ "1", "2", "3", "4", "5", "6" }), new LottoNumber(7)),
                Arguments.of(new LottoNumbers(new String[]{ "30", "1", "22", "41", "15", "36" }), new LottoNumber(12)),
                Arguments.of(new LottoNumbers(new String[]{ "41", "42", "43", "44", "45", "40" }), new LottoNumber(1))
        );
    }
}
