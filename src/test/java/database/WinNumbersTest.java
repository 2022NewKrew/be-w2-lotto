package database;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinNumbersTest {

    @DisplayName("당첨 번호 저장 및 조회가 잘 되는지")
    @Test
    void insertAndFindTest() {
        WinNumbers winNumbers = WinNumbers.getWinNumbers();

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        winNumbers.insert(numbers);
        winNumbers.insert(bonusNumber);

        assertEquals(numbers, winNumbers.findWinNumbers());
        assertEquals(bonusNumber, winNumbers.findBonusNumber());
    }
}
