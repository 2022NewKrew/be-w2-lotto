package com.kakaocorp.lotto.model;

import com.kakaocorp.lotto.validation.DuplicateNotAllowedException;
import com.kakaocorp.lotto.validation.IntCollectionValidator;
import com.kakaocorp.lotto.validation.IntRangeValidator;

import java.util.Set;

public class LottoRecord {

    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoRecord(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validate();
    }

    public LottoResult check(LottoTicket ticket) {
        return ticket.check(winningNumbers, bonusNumber);
    }

    private void validate() {
        int expectedSize = LottoTicket.NUMBER_COUNT;
        int minimum = LottoTicket.MIN_NUMBER;
        int maximum = LottoTicket.MAX_NUMBER;

        IntCollectionValidator winningNumbersValidator = new IntCollectionValidator(expectedSize, minimum, maximum);
        winningNumbersValidator.validate(winningNumbers);

        IntRangeValidator bonusNumberValidator = new IntRangeValidator(minimum, maximum);
        bonusNumberValidator.validate(bonusNumber);

        if (winningNumbers.contains(bonusNumber)) {
            throw new DuplicateNotAllowedException();
        }
    }
}
