package be.w2.lotto.domain;

public class RewardRule {
    private final int matchedNumber;
    private final boolean isBonus;
    private final int reward;

    private RewardRule(int matchedNumber, boolean isBonus, int reward) {
        this.matchedNumber = matchedNumber;
        this.isBonus = isBonus;
        this.reward = reward;
    }

    public static RewardRule valueOf(int matchedNumber, boolean isBonus, int reward) {
        return new RewardRule(matchedNumber, isBonus, reward);
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
