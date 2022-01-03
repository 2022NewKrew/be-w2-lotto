package carrot.ez.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LotteryGenerator {
    private static final List<Integer> lottoNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45);

    public static Lottery generateLotto() {
        Collections.shuffle(lottoNums);
        ArrayList<Integer> numbers = new ArrayList<>(lottoNums.subList(0, 6)); // 같은 참조값을 사용하지 않게 하기 위해 deep copy
        Collections.sort(numbers);
        return new Lottery(numbers);
    }

    private LotteryGenerator() {
    }
}
