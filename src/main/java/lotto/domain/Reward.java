package lotto.domain;

import java.util.Arrays;

public enum Reward {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int rewardPrize;
    private final boolean isHitBonus;

    Reward(int matchCount, int rewardPrize, boolean isHitBonus) {
        this.matchCount = matchCount;
        this.rewardPrize = rewardPrize;
        this.isHitBonus = isHitBonus;
    }

    public static Reward valueOf(int matchCount, boolean isBonus) {
        validateCount(matchCount);

        return Arrays.stream(Reward.values())
            .filter(reward -> reward.matchHitCount(matchCount, isBonus))
            .findFirst()
            .orElse(NONE);
    }

    private static void validateCount(int matchCount) {
        if (matchCount < NONE.matchCount || matchCount > FIRST.matchCount) {
            throw new IllegalArgumentException("[ERROR] 맞춘 개수는 0~6개 사이여야 합니다.");
        }
    }

    private boolean matchHitCount(int matchCount, boolean isHitBonus) {
        if (this.isHitBonus) {
            return matchCount == this.matchCount && isHitBonus;
        }
        return this.matchCount == matchCount;
    }


    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardPrize() {
        return rewardPrize;
    }

    public boolean isHitBonus() {
        return isHitBonus;
    }
}
