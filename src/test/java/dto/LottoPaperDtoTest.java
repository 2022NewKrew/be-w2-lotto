package dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoPaperDtoTest {

    @DisplayName("dto의 toString 테스트")
    @Test
    void testToString() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(1, 2, 13, 26, 33, 40);
        List<Integer> numbers3 = Arrays.asList(11, 20, 28, 39, 44, 45);
        List<List<Integer>> input = new ArrayList<>();
        input.add(numbers1);
        input.add(numbers2);
        input.add(numbers3);
        LottoPaperDto lottoPaperDto = new LottoPaperDto(input);

        String predict = "[1, 2, 3, 4, 5, 6]\n[1, 2, 13, 26, 33, 40]\n[11, 20, 28, 39, 44, 45]\n";

        assertEquals(predict, lottoPaperDto.toString());
    }
}
