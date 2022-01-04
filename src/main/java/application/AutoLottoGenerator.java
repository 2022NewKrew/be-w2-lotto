package application;

import domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {
    private final List<Integer> numbers = IntStream.rangeClosed(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());

    @Override
    public Lotto getLotto() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.stream()
                .distinct()
                .limit(Lotto.NUMBER)
                .collect(Collectors.toList()));
    }
}
