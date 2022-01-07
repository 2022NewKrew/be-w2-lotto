package lotto.dto;

import lotto.constant.ExceptionMessage;

import java.util.HashSet;
import java.util.List;

import static lotto.constant.Lotto.*;
import static lotto.util.LottoGenerator.getRandomNumbers;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this(getRandomNumbers());
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
        if(numbers.size() != PICK_SIZE.getValue()) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessage.INVALID_CREATE_LOTTO_SIZE.getMessage(), PICK_SIZE.getValue())
            );
        }
    }

    private void checkNumbersBound(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkNumberBound(number);
        }
    }

    private void checkNumberBound(Integer number) {
        if(!(MIN_NUM.getValue() <= number) && (number <= MAX_NUM.getValue())) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessage.INVALID_NUMBER_BOUND.getMessage(), MIN_NUM.getValue(), MAX_NUM.getValue())
            );
        }
    }

    private void checkDuplicatedNumbers(List<Integer> numbers) {
        if(new HashSet<>(numbers).size() < PICK_SIZE.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBERS.getMessage());
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
