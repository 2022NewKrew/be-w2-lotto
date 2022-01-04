package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class nNumber {
    private final List<Integer> numbers;

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUM_PER_LINE = 6;

    private nNumber() {
        List<Integer> fullNumbers = IntStream.range(MIN_NUM, MAX_NUM+1).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(fullNumbers);


        numbers = fullNumbers.subList(0,NUM_PER_LINE);
    }

    public static nNumber makeRandomNumbers() {
        return new nNumber();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
