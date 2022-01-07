package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomLottoNumbersGenerator implements LottoNumbersGenerator {

    private static final List<Integer> numbers = new ArrayList<>();

    static {
        IntStream.range(Constants.MIN_NUMBER_RANGE, Constants.MAX_NUMBER_RANGE)
                .forEach(numbers::add);
    }

    @Override
    public LottoNumbers generate() {
        Collections.shuffle(numbers);
        return new LottoNumbers(numbers.stream()
                .limit(Constants.LOTTO_NUMBER_SIZE)
                .sorted()
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList()));
    }
}
