package lotto.domain;

import lotto.configure.LottoConfigure;
import lotto.vo.LottoVO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> numbers;

    public Optional<List<Integer>> getNumbers() {
        return Optional.ofNullable(numbers);
    }

    public boolean isNumbers() {
        return Optional.ofNullable(numbers).isPresent();
    }

    public void generateNumbers() {
        List<Integer> candidateNumbers = IntStream
                .rangeClosed(LottoConfigure.MIN_NUMBER, LottoConfigure.MAX_NUMBER)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(candidateNumbers);
        numbers = candidateNumbers.subList(0, LottoConfigure.NUMBERS_SIZE);
        numbers.sort(Comparator.naturalOrder());
    }

}
