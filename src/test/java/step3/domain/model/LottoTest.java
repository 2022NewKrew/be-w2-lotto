package step3.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exceptions.DifferentSizeException;
import step3.exceptions.EmptyInputException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @DisplayName("수동 로또 입력에 빈 칸 또는 쉼표 (,)만 입력 시 오류 확인")
    @ParameterizedTest
    @ValueSource(strings = {"             ", ",,,,,"})
    public void lottoWrongInputTestWithBlanks(String lottoStr) {
        assertThrows(EmptyInputException.class, () -> new Lotto(lottoStr));
    }

    @DisplayName("수동 로또 입력에 잘못된 번호를 입력 시 오류 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,3,23,45\n", "-1, -2, -3, 1, 2, 3\n", "1, 5, 2, 4, 3, 6, 7\n"})
    public void lottoWrongInputTestWithWrongNumbers(String lottoStr) {
        assertThrows(DifferentSizeException.class, () -> new Lotto(lottoStr));
    }
}