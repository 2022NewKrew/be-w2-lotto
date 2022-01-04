package util;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomUtil {
    private static final List<Integer> numbers;

    static {
        numbers = IntStream
                .iterate(1, number -> number+1)
                .limit(45)
                .boxed()
                .collect(toList());
    }

    public static List<Integer> createRandomNumbers(){
        Collections.shuffle(numbers);
        List<Integer> randomNumbers = new ArrayList<>(numbers.subList(0, Lotto.NUMBER_OF_WRITE_NUMBER));
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
