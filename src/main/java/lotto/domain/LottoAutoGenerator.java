package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoAutoGenerator {
    public static final int MAX_DIGIT = 45;
    public static final int NUM_DIGITS = 6;

    public List<Lotto> getRandomLottos(long numLottos) {
        return Stream.generate(() -> new Lotto(getRandomDigits()))
                .limit(numLottos)
                .collect(Collectors.toList());
    }

    private @NotNull List<Integer> getRandomDigits() {
        List<Integer> randomDigits = Stream.iterate(1, n -> n + 1)
                .limit(MAX_DIGIT)
                .collect(Collectors.toList());
        Collections.shuffle(randomDigits);
        return randomDigits.subList(0, NUM_DIGITS);
    }
}
