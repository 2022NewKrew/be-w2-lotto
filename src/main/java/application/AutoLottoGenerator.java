package application;

import domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {
    private static final List<Integer> numbers = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    @Override
    public Lotto getLotto() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.stream()
                .distinct()
                .limit(6)
                .collect(Collectors.toList()));
    }
}
