package lotto.domain;

import java.util.Arrays;

public enum Reward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int rewardPrize;

    Reward(int matchCount, int rewardPrize) {
        this.matchCount = matchCount;
        this.rewardPrize = rewardPrize;
    }

    public static Reward valueOf(int matchCount) {
        validateCount(matchCount);

        return Arrays.stream(Reward.values())
            .filter(reward -> reward.equalsCount(matchCount))
            .findFirst()
            .orElse(NONE);
    }

    private static void validateCount(int matchCount) {
        if (matchCount < NONE.matchCount || matchCount > FIRST.matchCount) {
            throw new IllegalArgumentException("[ERROR] 맞춘 개수는 0~6개 사이여야 합니다.");
        }
    }

    private boolean equalsCount(int count) {
        return this.matchCount == count;
    }


    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardPrize() {
        return rewardPrize;
    }
}
