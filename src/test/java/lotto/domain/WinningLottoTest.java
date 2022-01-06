package lotto.domain;

import lotto.DuplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.view.LottoOutputPrinter.CHECK_DUPLICATION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    private List<LottoNumber> getLottoNumberListFrom(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(s -> Integer.parseInt(s.trim()))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @DisplayName("WinningLotto 생성 유효성 검사")
    @ParameterizedTest
    @MethodSource("invalidParameters")
    void invalidCreate(String numbers, int bonus, String expectedMessage) {
        Lotto winningLotto = new Lotto(getLottoNumberListFrom(numbers));
        LottoNumber bonusNumber = new LottoNumber(bonus);
        DuplicationException iae = assertThrows(DuplicationException.class, () -> new WinningLotto(winningLotto, bonusNumber));
        assertEquals(expectedMessage, iae.getMessage());
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", 3, CHECK_DUPLICATION_MESSAGE),
                Arguments.of("40,41,42,43,44,45", 43, CHECK_DUPLICATION_MESSAGE)
        );
    }
}