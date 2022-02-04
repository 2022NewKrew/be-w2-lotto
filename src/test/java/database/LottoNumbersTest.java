package database;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @DisplayName("LottoNumbers에 번호가 잘 저장되고 불러와지는지")
    @Test
    void getNumbersTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 13, 26, 33, 40);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        assertEquals(numbers, lottoNumbers.getNumbers());
    }
}
