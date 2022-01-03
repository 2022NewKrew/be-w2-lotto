package step1.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.exceptions.EmptyInputException;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @DisplayName("결과 입력에 빈 칸만 입력 시 오류 확인")
    @Test
    public void resultWrongInputTestWithOnlyBlanks() {
        String resultsStr = "        ";
        assertThrows(EmptyInputException.class, () -> new Result(resultsStr));
    }

    @DisplayName("결과 입력에 ,만 입력 시 오류 확인")
    @Test
    public void resultWrongInputTestWithOnlyCommas() {
        String resultsStr = ",,,,,";
        assertThrows(EmptyInputException.class, () -> new Result(resultsStr));
    }
}