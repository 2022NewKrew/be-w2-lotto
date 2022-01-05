package com.yapark97.lottoapplication.domain.winningPolicy;

import com.yapark97.lottoapplication.domain.lotto.Lotto;

public class BonusBallWinningPolicy implements WinningPolicy{
    // winningCondition 개를 맞추고 bonasBall도 맞추면 winningPrize 원을 받는 당첨 정책
    private final int bonusBall;
    private final WinningRank winningRank;

    public BonusBallWinningPolicy(int bonusBall, WinningRank winningRank) {
        this.bonusBall = bonusBall;
        this.winningRank = winningRank;
    }

    @Override
    public int getWinningPrize() {
        return winningRank.getWinningPrize();
    }

    @Override
    public boolean isWon(Lotto lotto, Lotto winningLotto) {
        int count = (int) winningLotto.getNumbers().stream()
                .map(lotto.getNumbers()::contains)
                .filter(c -> c)
                .count();

        return count == winningRank.getWinningCondition() && lotto.getNumbers().contains(bonusBall);
    }

    @Override
    public String toString() {
        return winningRank.getWinningCondition() + "개 일치, 보너스 볼 일치 (" + winningRank.getWinningPrize() + "원)";
    }

    @Override
    public int compareTo(WinningPolicy o) {
        return winningRank.getWinningPrize() - o.getWinningPrize();
    }
}
