package be.w2.lotto.dto;

import be.w2.lotto.domain.WinningMatchResult;

public class WinningMatchResultDto {
    public final int matchedNumber;
    public final int profit;
    public final int count;

    private WinningMatchResultDto(int matchedNumber, int profit, int count) {
        this.matchedNumber = matchedNumber;
        this.profit = profit;
        this.count = count;
    }

    public static WinningMatchResultDto from(WinningMatchResult winningMatchResult) {
        return new WinningMatchResultDto(
                winningMatchResult.getMatchedNumber(),
                winningMatchResult.getProfit(),
                winningMatchResult.getCount()
        );
    }
}
