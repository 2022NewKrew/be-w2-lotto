package org.cs.finn.lotto.domain;

import org.assertj.core.api.Assertions;
import org.cs.finn.lotto.domain.lotto.LottoNumber;
import org.cs.finn.lotto.domain.lotto.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
}
