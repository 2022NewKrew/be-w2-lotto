package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {

    private static final int LOTTO_SIZE_MIN = 0;
    private static final int LOTTO_SIZE_MAX = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> randomNumbers;

    private RandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = new ArrayList<>(randomNumbers);
    }

    public static RandomNumbers createRandomNumbers() {
        List<Integer> randomNumbers = IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            .boxed()
            .collect(Collectors.toList());

        return new RandomNumbers(randomNumbers);
    }

    public List<Integer> shuffle() {
        Collections.shuffle(this.randomNumbers);
        return this.randomNumbers.subList(LOTTO_SIZE_MIN, LOTTO_SIZE_MAX);
    }
}
