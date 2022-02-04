package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("로또 번호 자동 생성 테스트")
    @Test
    void createNumbers() {
        List<Integer> lottoNumbers = LottoGenerator.createNumbers();
        int pre = 0;

        assertEquals(6, lottoNumbers.size());
        for (Integer number : lottoNumbers) {
            assertTrue(number >= 1 && number <= 45);
            assertTrue(pre < number);
            pre = number;
        }
    }
}
