package lotto.domain.generator;

import lotto.configure.LottoConfigure;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator implements LottoGenerator {

    private List<Integer> shuffled(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(0,LottoConfigure.NUMBERS_SIZE));
    }

    private List<Integer> generateNumbers() {
        return IntStream.rangeClosed(LottoConfigure.MIN_NUMBER, LottoConfigure.MAX_NUMBER).
                boxed().collect(Collectors.toList());
    }

    @Override
    public Lotto generateLotto() {
        return new Lotto(shuffled(generateNumbers()));
    }

}
