package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator {
    public static final int NUMBER_POOL_SIZE = 45;
    public static final int NUMBERS_TO_PICK = 6;

    private static final List<Integer> nextRandomNumbers = IntStream.rangeClosed(1, NUMBER_POOL_SIZE)
            .boxed().collect(Collectors.toList());

    public static Set<Integer> generateRandomLottoNumbers() {
        Collections.shuffle(nextRandomNumbers);
        return new HashSet<>(nextRandomNumbers.subList(0, NUMBERS_TO_PICK));
    }
}
