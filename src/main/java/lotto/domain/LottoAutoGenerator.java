package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoAutoGenerator {
    public static final int MIN_DIGIT = 1;
    public static final int MAX_DIGIT = 45;
    public static final int NUM_DIGITS = 6;

    public List<Lotto> getRandomLottos(long numLottos) {
        return Stream.generate(() -> new Lotto(getRandomDigits()))
                .limit(numLottos)
                .collect(Collectors.toList());
    }

    private @NotNull List<Integer> getRandomDigits() {
        List<Integer> randomDigits = IntStream.rangeClosed(MIN_DIGIT, MAX_DIGIT)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(randomDigits);
        return randomDigits.subList(0, NUM_DIGITS);
    }
}
