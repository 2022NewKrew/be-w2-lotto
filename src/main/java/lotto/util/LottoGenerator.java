package lotto.util;

import lotto.constant.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final List<Integer> numbers = IntStream
            .rangeClosed(Lotto.MIN_NUM.getValue(), Lotto.MAX_NUM.getValue())
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> getRandomNumbers() {
        Collections.shuffle(numbers);
        return List.copyOf(numbers.subList(0, Lotto.PICK_SIZE.getValue()));
    }
}
