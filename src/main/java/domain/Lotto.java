package domain;

import exceptions.InvalidLastWeekWinningNumber;
import messages.ErrorMessage;
import validation.Validation;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private final Set<Integer> numbers;
    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    Lotto(Set<Integer> numbers) {
        if (numbers == null)
            throw new IllegalArgumentException();
        // Validation.lengthShouldBe(numbers, NUMBER_OF_LOTTERY_NUMBERS, new InvalidLastWeekWinningNumber(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        numbers.forEach(num -> {
            Validation.notLessThanLong(num, MIN_LOTTO_NUMBER, new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_WINNING_NUMBER.getMessage()));
            Validation.notMoreThanLong(num, MAX_LOTTO_NUMBER, new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_WINNING_NUMBER.getMessage()));
        });
//        this.numbers = Collections.unmodifiableList(numbers);
        this.numbers = numbers;
    }

    public Set<Integer> numbers() {
        return this.numbers;
    }

    public Integer checkMatchCount(Set<Integer> winningNumbers) {
        Set<Integer> copyWinningNumbers = new HashSet<>(winningNumbers);
        copyWinningNumbers.retainAll(numbers);
        return copyWinningNumbers.size();
    }
}
