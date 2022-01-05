package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final int NUMBER_COUNT = 6;
    public static final int LOTTO_INCLUSIVE_RANGE_END = 45;
    public static final List<Integer> numbers = IntStream.rangeClosed(1, LOTTO_INCLUSIVE_RANGE_END).boxed().collect(Collectors.toList());

    public Lotto generate() {
        List<Integer> clonedNumbers = new ArrayList<>(numbers);
        Collections.shuffle(clonedNumbers);
        return new Lotto(clonedNumbers.stream().limit(NUMBER_COUNT).collect(Collectors.toList()));
    }
}
