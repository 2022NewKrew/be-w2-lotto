package be.w2.lotto.dto;

import be.w2.lotto.domain.winningresult.WinningMatchResult;

public class WinningMatchResultDto {
    public final int matchedNumber;
    public final int reward;
    public final int count;
    public final boolean isBonusRound;

    public WinningMatchResultDto(WinningMatchResult winningMatchResult) {
        this.matchedNumber = winningMatchResult.getMatchedNumber();
        this.reward = winningMatchResult.getReward();
        this.count = winningMatchResult.getCount();
        this.isBonusRound = winningMatchResult.isBonusRound();
    }
}
