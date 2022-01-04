package step2.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exceptions.DuplicatedNumberException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusNumberTest {
    @DisplayName("보너스 번호 입력에 범위를 벗어난 번호를 입력 시 오류 확인")
    @Test
    void bonusNumberWrongInputTestWithWrongNumber() {
        Result result = new Result("1, 2, 3, 4, 5, 6\n");
        assertThrows(NumberFormatException.class, () -> new BonusNumber(46, result));
    }

    @DisplayName("보너스 번호 입력에 이미 결과에 입력된 번호를 입력 시 오류 확인")
    @Test
    void bonusNumberWrongInputTestWithDuplicatedNumber() {
        Result result = new Result("1, 2, 3, 4, 5, 6\n");
        assertThrows(DuplicatedNumberException.class, () -> new BonusNumber(6, result));
    }
}