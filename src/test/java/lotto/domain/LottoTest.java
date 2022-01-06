package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.Lotto.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    private List<LottoNumber> getLottoNumberListFrom(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(s -> Integer.parseInt(s.trim()))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @DisplayName("Lotto 생성 유효성 검사")
    @ParameterizedTest
    @MethodSource("invalidParameters")
    void invalidCreate(String numbers, String expectedMessage) {
        List<LottoNumber> lottoNumberList = getLottoNumberListFrom(numbers);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumberList));
        assertEquals(iae.getMessage(), expectedMessage);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
                Arguments.of("1,1,2,3,4,5", CHECK_DUPLICATION_MESSAGE),
                Arguments.of("41,42,43,44,45,45", CHECK_DUPLICATION_MESSAGE),
                Arguments.of("1,2,3,4,5,6,7", CHECK_NUM_OF_LOTTO_NUMBERS),
                Arguments.of("39,40,41,42,43,44,45", CHECK_NUM_OF_LOTTO_NUMBERS)
        );
    }

    @DisplayName("두 로또 사이에 일치하는 번호 개수가 6개(로또번호 개수) 이하인지 확인")
    @ParameterizedTest
    @MethodSource("validParameters")
    void getNumOfMatchingNumbersWith(String numbers1, String numbers2) {
        Lotto lotto1 = new Lotto(getLottoNumberListFrom(numbers1));
        Lotto lotto2 = new Lotto(getLottoNumberListFrom(numbers2));
        Assertions.assertTrue(lotto1.getNumOfMatchingNumbersWith(lotto2) <= NUM_OF_LOTTO_NUMBERS_IN_LOTTO);
    }

    static Stream<Arguments> validParameters() {
        return Stream.of(
                Arguments.of("2,4,6,8,10,12", "2,4,6,8,10,12"),
                Arguments.of("2,4,6,8,10,12", "1,2,3,4,5,6")
        );
    }

    @DisplayName("로또가 특정 번호를 포함하고 있는지 확인")
    @ParameterizedTest
    @MethodSource("containTestParameters")
    void containsLottoNumber(String numbers, int containNum, boolean expected) {
        Lotto lotto = new Lotto(getLottoNumberListFrom(numbers));
        assertThat(lotto.containsLottoNumber(new LottoNumber(containNum))).isEqualTo(expected);
    }

    static Stream<Arguments> containTestParameters() {
        return Stream.of(
                Arguments.of("2,4,6,8,10,12", 1, false),
                Arguments.of("2,4,6,8,10,12", 2, true),
                Arguments.of("2,4,6,8,10,12", 3, false),
                Arguments.of("2,4,6,8,10,12", 4, true)
        );
    }
}