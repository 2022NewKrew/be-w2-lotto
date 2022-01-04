package com.kakaocorp.lotto.model;

import java.util.Set;

public class LottoRecord {

    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoRecord(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult check(LottoTicket ticket) {
        return ticket.check(winningNumbers, bonusNumber);
    }
}
