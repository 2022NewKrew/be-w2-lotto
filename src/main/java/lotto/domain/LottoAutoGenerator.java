package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoAutoGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUM_OF_LOTTO_NUMBERS = 6;

    public List<Lotto> getRandomLottos(long numOfLottos) {
        return Stream.generate(() -> new Lotto(getRandomLottoNumbers()))
                .limit(numOfLottos)
                .collect(Collectors.toList());
    }

    private @NotNull List<LottoNumber> getRandomLottoNumbers() {
        List<Integer> randomNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0, NUM_OF_LOTTO_NUMBERS)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
