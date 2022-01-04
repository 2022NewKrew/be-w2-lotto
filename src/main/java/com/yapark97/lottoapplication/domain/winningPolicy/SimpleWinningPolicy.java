package com.yapark97.lottoapplication.domain.winningPolicy;

import com.yapark97.lottoapplication.domain.lotto.Lotto;

public class SimpleWinningPolicy implements WinningPolicy{
    // winningCondition 개를 맞추면 winningPrize 원을 받는 당첨 정책
    private final int winningCondition;
    private final int winningPrize;

    public SimpleWinningPolicy(int winningCondition, int winningPrize) {
        this.winningCondition = winningCondition;
        this.winningPrize = winningPrize;
    }

    @Override
    public boolean isWon(Lotto lotto, Lotto winningLotto) {
        int count = (int) winningLotto.getNumbers().stream()
                .map(lotto.getNumbers()::contains)
                .filter(c -> c)
                .count();

        return count == winningCondition;
    }

    @Override
    public String toString() {
        return winningCondition + "개 일치 (" + winningPrize + "원)";
    }
}
