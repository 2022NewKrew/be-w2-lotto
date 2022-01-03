package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.constant.Constants.*;

public class RandomNumberCreator {

    private static final List<Integer> ALL_OF_NUMBERS;
    static {
        ALL_OF_NUMBERS = new ArrayList<>();
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER).forEach(ALL_OF_NUMBERS::add);
    }

    public static List<Integer> createRandomNumbers() {
        Collections.shuffle(ALL_OF_NUMBERS);

        List<Integer> randomNumbers = ALL_OF_NUMBERS.subList(0, NUM_OF_WINNING_NUMBERS);
        Collections.sort(randomNumbers);

        return List.copyOf(randomNumbers);
    }
}
