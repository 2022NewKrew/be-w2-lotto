package util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtil {

    private static final int LOTTO_SIZE_MIN = 0;
    private static final int LOTTO_SIZE_MAX = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private static final List<Integer> randomNumbers;

    static {
        randomNumbers = IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            .boxed()
            .collect(Collectors.toList());
    }

    private RandomUtil() {
    }

    public static List<Integer> generateRandomNumbers() {
        Collections.shuffle(randomNumbers);
        return Collections.unmodifiableList(randomNumbers.subList(LOTTO_SIZE_MIN, LOTTO_SIZE_MAX));
    }
}
