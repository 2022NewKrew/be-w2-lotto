package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LottoGenerable {
    int NUMBER_COUNT = 6;
    int LOTTO_INCLUSIVE_RANGE_END = 45;
    List<Integer> numbers = IntStream.rangeClosed(1, LOTTO_INCLUSIVE_RANGE_END).boxed().collect(Collectors.toList());

    Lotto generate();
}
