package util;

import domain.RandomNumbers;
import java.util.Collections;
import java.util.List;

public class RandomUtil {
    private static final RandomNumbers randomNumbers = RandomNumbers.createRandomNumbers();

    private RandomUtil() {}

    public static List<Integer> generateRandomNumbers() {
        return Collections.unmodifiableList(randomNumbers.shuffle());
    }
}
