package lottogame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RandomCollection {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static List<Integer> numbers = Stream.iterate(MIN_NUMBER, n -> n + 1)
            .limit(MAX_NUMBER)
            .collect(Collectors.toList());

    private RandomCollection() {
    }

    public static List<Integer> returnNumbers() {
        Collections.shuffle(numbers);
        List<Integer> randomNumbers = numbers.subList(0, 6);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}