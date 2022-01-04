package com.yapark97.lottoapplication.domain.winningPolicy;

import com.yapark97.lottoapplication.domain.lotto.Lotto;

public class BonusBallWinningPolicy implements WinningPolicy{
    // winningCondition 개를 맞추고 bonasBall도 맞추면 winningPrize 원을 받는 당첨 정책
    private final int bonusBall;
    private final int winningCondition;
    private final int winningPrize;

    public BonusBallWinningPolicy(int bonusBall, int winningCondition, int winningPrize) {
        this.bonusBall = bonusBall;
        this.winningCondition = winningCondition;
        this.winningPrize = winningPrize;
    }

    @Override
    public int getWinningPrize() {
        return winningPrize;
    }

    @Override
    public boolean isWon(Lotto lotto, Lotto winningLotto) {
        int count = (int) winningLotto.getNumbers().stream()
                .map(lotto.getNumbers()::contains)
                .filter(c -> c)
                .count();

        return count == winningCondition && lotto.getNumbers().contains(bonusBall);
    }

    @Override
    public String toString() {
        return winningCondition + "개 일치, 보너스 볼 일치 (" + winningPrize + "원)";
    }
}
