package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isNumbers() {
        return numbers != null;
    }

    public void generateNumbers() {
        List<Integer> candidatedNumbers = IntStream
                .rangeClosed(LottoDto.MIN_NUMBER, LottoDto.MAX_NUMBER)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(candidatedNumbers);
        numbers = candidatedNumbers.subList(0, LottoDto.NUMBERS_SIZE);
        numbers.sort(Comparator.naturalOrder());
    }

}
