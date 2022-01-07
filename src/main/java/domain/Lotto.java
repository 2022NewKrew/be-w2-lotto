package domain;

import enums.LottoConstants;
import exceptions.InvalidLastWeekWinningNumber;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import messages.ErrorMessage;
import validation.Validation;

public class Lotto {

    private final Set<LottoNumber> numbers;

    Lotto(Set<Integer> intNumbers) {
        if (intNumbers == null) {
            throw new IllegalArgumentException();
        }
        Validation.sizeShouldBe(intNumbers, LottoConstants.NUMBER_OF_LOTTERY_NUMBERS.get(),
                new InvalidLastWeekWinningNumber(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        numbers = intNumbers.stream().map(LottoNumber::new).collect(Collectors.toUnmodifiableSet());
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
