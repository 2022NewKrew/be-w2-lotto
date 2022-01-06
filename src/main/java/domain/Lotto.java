package domain;

import exceptions.InvalidLastWeekWinningNumber;
import messages.ErrorMessage;
import validation.Validation;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    Lotto(List<Integer> numbers) {
        if (numbers == null)
            throw new IllegalArgumentException();
        Validation.lengthShouldBe(numbers, NUMBER_OF_LOTTERY_NUMBERS, new InvalidLastWeekWinningNumber(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        numbers.forEach(num -> {
            Validation.notLessThanLong(num, MIN_LOTTO_NUMBER, new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_WINNING_NUMBER.getMessage()));
            Validation.notMoreThanLong(num, MAX_LOTTO_NUMBER, new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_WINNING_NUMBER.getMessage()));
        });
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> numbers() {
        return this.numbers;
    }

    public Integer checkMatchCount(List<Integer> winningNumbers) {
        // TODO - 몇개의 번호가 일치하는지 확인
        return 6;
    }
}
