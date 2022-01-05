package be.w2.lotto.domain.winningresult;

import java.util.stream.Stream;

public enum Rewards {
    MATCH_THREE(3, false, 5000),
    MATCH_FOUR(4, false, 50000),
    MATCH_FIVE(5, false, 1500000),
    MATCH_FIVE_BONUS(5, true, 30000000),
    MATCH_SIX(6, false, 2000000000);

    Rewards(int matchedNumber, boolean isBonus, int reward) {
        this.matchedNumber = matchedNumber;
        this.isBonus = isBonus;
        this.reward = reward;
    }

    private final int matchedNumber;
    private final boolean isBonus;
    private final int reward;

    public static Stream<Rewards> stream() {
        return Stream.of(Rewards.values());
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
