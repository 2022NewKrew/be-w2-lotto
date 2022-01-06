package lotto.domain;

import java.util.Arrays;

public enum Reward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int rewardPrize;
    private final boolean bonusMatch;

    Reward(int matchCount, int rewardPrize, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.rewardPrize = rewardPrize;
        this.bonusMatch = bonusMatch;
    }

    Reward(int matchCount, int rewardPrize) {
        this.matchCount = matchCount;
        this.rewardPrize = rewardPrize;
        this.bonusMatch = false;
    }

    public static Reward of(int matchCount, boolean bonusMatch) {
        validateCount(matchCount);

        return Arrays.stream(Reward.values())
            .filter(reward -> reward.equalsCount(matchCount))
            .filter(reward -> reward.equalsBonusMatch(bonusMatch))
            .findFirst()
            .orElse(NONE);
    }

    private static void validateCount(int matchCount) {
        if (matchCount < NONE.matchCount || matchCount > FIRST.matchCount) {
            throw new IllegalArgumentException("[ERROR] 맞춘 개수는 0~6개 사이여야 합니다.");
        }
    }

    private boolean equalsCount(int count) {
        return matchCount == count;
    }

    private boolean equalsBonusMatch(boolean match) {
        return bonusMatch == match;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardPrize() {
        return rewardPrize;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
