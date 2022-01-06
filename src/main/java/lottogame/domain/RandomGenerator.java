package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator implements LotteryNumbersGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private List<LotteryNumber> numbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(LotteryNumber::new).collect(Collectors.toList());

    public RandomGenerator() {
    }

    public LotteryNumbers generate() {
        Collections.shuffle(numbers);
        List<LotteryNumber> randomNumbers = new ArrayList<>(numbers.subList(0, 6));
        Collections.sort(randomNumbers);
        return new LotteryNumbers(randomNumbers);
    }
}
