package domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum RewardType {
    NONE(0, 0,
            (numOfMatched, isBonusMatched) -> numOfMatched < 4),
    FOURTH_PLACE(4, 5_000,
            (numOfMatched, isBonusMatched) -> numOfMatched == 4),
    THIRD_PLACE(5, 50_000,
            (numOfMatched, isBonusMatched) -> numOfMatched == 5 && !isBonusMatched),
    SECOND_PLACE(5, 1_500_000,
            (numOfMatched, isBonusMatched) -> numOfMatched == 5 && isBonusMatched),
    FIRST_PLACE(6, 2_000_000_000,
            (numOfMatched, isBonusMatched) -> numOfMatched == 6);

    private final int matched;
    private final long reward;
    private final BiPredicate<Integer, Boolean> matchingFunction;

    RewardType(int matched, long reward, BiPredicate<Integer,Boolean> matchingFunction) {
        this.matched = matched;
        this.reward = reward;
        this.matchingFunction = matchingFunction;
    }

    public long getReward() {
        return reward;
    }

    private boolean equals(int numOfMatched, boolean isBonusMatched){
        return this.matchingFunction.test(numOfMatched, isBonusMatched);
    }

    public static RewardType of(int numOfMatched, boolean isBonusMatched) {
        return Arrays.stream(RewardType.values())
                .filter(rewardType -> rewardType.equals(numOfMatched, isBonusMatched))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public String toString() {
        return String.valueOf(matched)
                .concat("개 일치 (")
                .concat(String.valueOf(reward))
                .concat(") - ");
    }
}
