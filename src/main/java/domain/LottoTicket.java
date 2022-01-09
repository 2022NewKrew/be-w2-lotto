package domain;

import exceptions.InvalidLastWeekWinningNumber;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import messages.ErrorMessage;
import validation.Validation;

public class LottoTicket {

    private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;
    private final Set<LottoNumber> numbers;

    LottoTicket(Set<LottoNumber> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        Validation.sizeShouldBe(numbers, NUMBER_OF_LOTTERY_NUMBERS,
                () -> new InvalidLastWeekWinningNumber(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        this.numbers = numbers.stream().collect(Collectors.toUnmodifiableSet());
    }

    public Set<LottoNumber> numbers() {
        return this.numbers;
    }

    public Integer matchCount(Set<LottoNumber> winningNumbers) {
        Set<LottoNumber> copyWinningNumbers = new HashSet<>(winningNumbers);
        copyWinningNumbers.retainAll(numbers);
        return copyWinningNumbers.size();
    }

    public boolean contains(LottoNumber findNumber) {
        return numbers.contains(findNumber);
    }
}
