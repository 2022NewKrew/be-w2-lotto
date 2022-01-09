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

    LottoTicket(Set<Integer> intNumbers) {
        if (intNumbers == null) {
            throw new IllegalArgumentException();
        }
        Validation.sizeShouldBe(intNumbers, NUMBER_OF_LOTTERY_NUMBERS,
                () -> new InvalidLastWeekWinningNumber(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        numbers = intNumbers.stream().map(LottoNumber::from).collect(Collectors.toUnmodifiableSet());
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
