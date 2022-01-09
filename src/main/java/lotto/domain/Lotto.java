package lotto.domain;

import lotto.constant.ExceptionMessage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    protected static final int COUNT_OF_LOTTO_NUMBER = 6;

    private static final List<Integer> createNumbers = IntStream
            .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());


    private final List<Integer> numbers;

    public Lotto() {
        this(getRandomNumbers());
    }

    private static List<Integer> getRandomNumbers() {
        Collections.shuffle(createNumbers);
        List<Integer> createdNumbers = new ArrayList<>();
        for (Integer number : (createNumbers.subList(0, COUNT_OF_LOTTO_NUMBER))) {
            createdNumbers.add(number);
        }
        Collections.sort(createdNumbers);
        return createdNumbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkCreateSize(numbers);
        checkNumbersBound(numbers);
        checkDuplicatedNumbers(numbers);
    }

    private void checkCreateSize(List<Integer> numbers) {
        if(numbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessage.INVALID_CREATE_LOTTO_SIZE.getMessage(), COUNT_OF_LOTTO_NUMBER)
            );
        }
    }

    private void checkNumbersBound(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkNumberBound(number);
        }
    }

    private void checkNumberBound(Integer number) {
        if(!(MIN_LOTTO_NUMBER <= number) && (number <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessage.INVALID_NUMBER_BOUND.getMessage(), MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            );
        }
    }

    private void checkDuplicatedNumbers(List<Integer> numbers) {
        if(new HashSet<>(numbers).size() < COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBERS.getMessage());
        }
    }


    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Set<Integer> getSetNumbers() {
        return new HashSet<>(numbers);
    }
    @Override
    public String toString() {
        return numbers.toString();
    }
}
