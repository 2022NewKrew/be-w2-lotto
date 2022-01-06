package lotto.domain;

import java.util.Arrays;

public enum Rank {
    THREE_MATCH(3, 5_000, false),
    FOUR_MATCH(4, 50_000, false),
    FIVE_MATCH(5, 1_500_000, false),
    BONUS_MATCH(5, 30_000_000, true),
    SIX_MATCH(6, 2_000_000_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final long winningMoney;
    private final boolean containBonusBall;

    Rank(int matchCount, long winningMoney, boolean containBonusBall) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.containBonusBall = containBonusBall;
    }

    public static Rank valueOf(boolean containBonusBall, int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(containBonusBall, matchCount))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(boolean containBonusBall, int matchCount) {
        if (containBonusBall) {
            return this.matchCount == matchCount && containBonusBall;
        }

        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
