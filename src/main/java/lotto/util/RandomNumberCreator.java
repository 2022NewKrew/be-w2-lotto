package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constant.Constants.*;

public class RandomNumberCreator {

    private static final List<Integer> ALL_OF_NUMBERS;
    static {
        ALL_OF_NUMBERS = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
    }

    public static List<Integer> createRandomNumbers() {
        Collections.shuffle(ALL_OF_NUMBERS);

        return ALL_OF_NUMBERS.stream()
                    .limit(NUM_OF_WINNING_NUMBERS)
                    .sorted()
                    .collect(Collectors.toList());
    }
}
