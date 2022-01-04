package step2.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exceptions.DifferentSizeException;
import step2.exceptions.EmptyInputException;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @DisplayName("결과 입력에 빈 칸 또는 쉼표 (,)만 입력 시 오류 확인")
    @ParameterizedTest
    @ValueSource(strings = {"             ", ",,,,,"})
    public void resultWrongInputTestWithBlanks(String resultStr) {
        assertThrows(EmptyInputException.class, () -> new Result(resultStr));
    }

    @DisplayName("결과 입력에 잘못된 번호를 입력 시 오류 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,3,23,45\n", "23, 24, 25, 26, 27, 28, 29\n", "-1, 5, 2, 3, 5, 1\n"})
    public void resultWrongInputTestWithWrongNumbers(String resultStr) {
        assertThrows(DifferentSizeException.class, () -> new Result(resultStr));
    }
}