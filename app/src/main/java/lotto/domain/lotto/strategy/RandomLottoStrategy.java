package lotto.domain.lotto.strategy;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomLottoStrategy implements LottoStrategy {

    private static final List<Integer> seedNumber = IntStream.rangeClosed(1, 45).boxed().collect(toList());

    @Override
    public List<Integer> create() {
        Collections.shuffle(seedNumber);
        return seedNumber.stream()
                .limit(6)
                .sorted()
                .collect(toList());
    }
}
