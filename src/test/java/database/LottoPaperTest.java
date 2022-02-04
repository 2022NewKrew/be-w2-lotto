package database;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoPaperTest {

    @DisplayName("LottoPaper에 번호가 잘 저장되고 불러와지는지")
    @Test
    void insertAndFindAllTest() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(1, 2, 13, 26, 33, 40);
        List<Integer> numbers3 = Arrays.asList(11, 20, 28, 39, 44, 45);
        LottoPaper lottoPaper = LottoPaper.getLottoPaper();

        lottoPaper.insert(numbers1);
        lottoPaper.insert(numbers2);
        lottoPaper.insert(numbers3);

        List<List<Integer>> predict = new ArrayList<>();
        predict.add(numbers1);
        predict.add(numbers2);
        predict.add(numbers3);

        assertEquals(predict, lottoPaper.findAll());
    }

}
