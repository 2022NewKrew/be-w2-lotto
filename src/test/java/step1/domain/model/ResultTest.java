package step1.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.exceptions.DifferentSizeException;
import step1.exceptions.EmptyInputException;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @DisplayName("결과 입력에 빈 칸만 입력 시 오류 확인")
    @Test
    public void resultWrongInputTestWithOnlyBlanks() {
        assertThrows(EmptyInputException.class, () -> new Result("        "));
    }

    @DisplayName("결과 입력에 ,만 입력 시 오류 확인")
    @Test
    public void resultWrongInputTestWithOnlyCommas() {
        assertThrows(EmptyInputException.class, () -> new Result(",,,,,"));
    }

    @DisplayName("결과 입력에 잘못된 번호를 입력 시 오류 확인")
    @Test
    public void resultWrongInputTestWithDifferentSize() {
        assertThrows(DifferentSizeException.class, () -> new Result("1,2,3,3,23,45\n"));
        assertThrows(DifferentSizeException.class, () -> new Result("23, 24, 25, 26, 27, 28, 29\n"));
        assertThrows(DifferentSizeException.class, () -> new Result("-1, 5, 2, 3, 5, 1\n"));
    }
}