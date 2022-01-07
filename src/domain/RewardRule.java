package domain;

import java.util.Arrays;
import java.util.List;

public enum RewardRule {
    FIFTH_PLACE(3, 5_000, false),
    FOURTH_PLACE(4, 50_000, false),
    THIRD_PLACE(5, 1_500_000, false),
    SECOND_PLACE(5, 30_000_000, true),
    FIRST_PLACE(6, 2_000_000_000, false);

    private final int numOfMatch;
    private final int reward;
    private final boolean isBonus;

    private static final List<Integer> matchForEachRewards = Arrays.asList(3, 4, 5, 5, 6);
    private static final List<String> rewardName = Arrays.asList(
            "FIFTH_PLACE", "FOURTH_PLACE", "THIRD_PLACE", "SECOND_PLACE", "FIRST_PLACE");
    private static final List<String> rewardNameWithoutBonus = Arrays.asList("", "", "",
            "FIFTH_PLACE", "FOURTH_PLACE", "THIRD_PLACE", "FIRST_PLACE");
    private static final String rewardNameWithBonus = "SECOND_PLACE";

    RewardRule(int numOfMatch, int reward, boolean isBonus) {
        this.numOfMatch = numOfMatch;
        this.reward = reward;
        this.isBonus = isBonus;
    }

    public int getNumOfMatch() {
        return this.numOfMatch;
    }

    public int getReward() {
        return this.reward;
    }

    public boolean getIsBonus() {
        return this.isBonus;
    }

    public static List<String> getRewardName() {
        return rewardName;
    }

    public static List<Integer> getMatchForEachRewards() {
        return matchForEachRewards;
    }

    public static List<String> getRewardNameWithoutBonus() {
        return rewardNameWithoutBonus;
    }

    public static String getRewardNameWithBonus() {
        return rewardNameWithBonus;
    }
}
