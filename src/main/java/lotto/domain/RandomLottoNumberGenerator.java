package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator {
    public static final int NUMBER_POOL_SIZE = 45;
    public static final int NUMBERS_TO_PICK = 6;

    private static final List<Integer> nextRandomNumbers = IntStream.rangeClosed(1, NUMBER_POOL_SIZE)
            .boxed().collect(Collectors.toList());

    /**
     * @return [1, {@value #NUMBER_POOL_SIZE}] 범위에서 중복되지 않게
     * {@value #NUMBERS_TO_PICK}개 뽑은 {@link Set}
     */
    public static Set<Integer> generateRandomLottoNumbers() {
        Collections.shuffle(nextRandomNumbers);
        return new TreeSet<>(nextRandomNumbers.subList(0, NUMBERS_TO_PICK));
    }
}
