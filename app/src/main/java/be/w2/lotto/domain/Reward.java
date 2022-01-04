package be.w2.lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public enum Reward {
    MATCH_THREE(3, false, 5000),
    MATCH_FOUR(4, false, 50000),
    MATCH_FIVE(5, false, 1500000),
    MATCH_FIVE_BONUS(5, true, 30000000),
    MATCH_SIX(6, false, 2000000000);

    Reward(int matchedNumber, boolean isBonus, int reward) {
        this.matchedNumber = matchedNumber;
        this.isBonus = isBonus;
        this.reward = reward;
    }

    private final int matchedNumber;
    private final boolean isBonus;
    private final int reward;

    public static Stream<Reward> stream() {
        return Stream.of(Reward.values());
    }

    public boolean hasSameMatchedNumber(int number) {
        return this.matchedNumber == number;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getReward() {
        return reward;
    }
}
