package com.yapark97.lottoapplication.domain.winningPolicy;

import com.yapark97.lottoapplication.domain.lotto.Lotto;

public interface WinningPolicy {
    boolean isWon(Lotto lotto, Lotto winningLotto);
}
