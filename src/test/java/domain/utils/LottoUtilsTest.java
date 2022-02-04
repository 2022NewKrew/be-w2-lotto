package domain.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoUtilsTest {

    @DisplayName("String을 숫자로 잘 쪼개는 지")
    @Test
    void splitSixNumTest() {
        String numbers1 = "1, 2, 3, 4, 5, 6";
        String numbers2 = "1,2,3,4,5,6";

        List<Integer> predict = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertEquals(predict, LottoUtils.splitSixNum(numbers1));
        assertEquals(predict, LottoUtils.splitSixNum(numbers2));
    }
}
