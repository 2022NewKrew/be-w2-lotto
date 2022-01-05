package lotto.domain.model;

import java.util.*;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<Integer> allNumbers;

    static {
        List<Integer> range = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(range::add);
        allNumbers = Collections.unmodifiableList(range);
    }

    private List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>(allNumbers.size());
        numbers.addAll(allNumbers);
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 6);
        Collections.sort(numbers);
    }

    public Lotto(List<Integer> numbers) {
        // TODO: numbers의 원소 수 검증
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
