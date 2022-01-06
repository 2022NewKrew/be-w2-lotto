package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumbersFactory {
    private static final int NUMBER_DOMAIN_START = 1;
    private static final int NUMBER_DOMAIN_END = 45;
    private static final List<Integer> NUMBERS_DOMAIN = IntStream.rangeClosed(NUMBER_DOMAIN_START, NUMBER_DOMAIN_END).boxed().collect(Collectors.toList());
    private static final int NUMBERS_LENGTH = 6;

    public List<Integer> getRandomNumbers() {
        Collections.shuffle(NUMBERS_DOMAIN);
        List<Integer> numbers = new ArrayList<>(NUMBERS_DOMAIN.subList(0, NUMBERS_LENGTH));
        Collections.sort(numbers);
        return numbers;
    }
}
