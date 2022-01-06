package lotto.domain.lotto.number;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumberFactory {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final List<Integer> seedNumber = IntStream.rangeClosed(START_NUMBER, END_NUMBER).boxed().collect(toList());

    public List<Integer> generateRandomLotto() {
        Collections.shuffle(seedNumber);
        return seedNumber.stream()
                .limit(LOTTO_LENGTH)
                .sorted()
                .collect(toList());
    }

    public List<Integer> generateManualLotto(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(toList());
    }
}
