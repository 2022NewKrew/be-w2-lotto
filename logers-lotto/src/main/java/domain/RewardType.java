package domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public enum RewardType {
    NONE(0, false, 0),
    FOURTH_PLACE(4, false, 5000),
    THIRD_PLACE(5, false, 50000),
    SECOND_PLACE(5, true, 1500000),
    FIRST_PLACE(6, false, 2000000000);

    private final int matched;
    private final boolean hasBonus;
    private final int reward;

    RewardType(int matched, boolean hasBonus, int reward) {
        this.matched = matched;
        this.hasBonus = hasBonus;
        this.reward = reward;
    }

    public int getMatched() {
        return matched;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }

    public int getReward() {
        return reward;
    }

    public boolean equals(int matched, boolean hasBonus){
        if(this.matched != SECOND_PLACE.matched){
            return this.matched == matched;
        }

        return this.matched == matched && this.hasBonus == hasBonus;
    }

    public static RewardType getRewardType(int matched, boolean hasBonus){
        List<RewardType> rewardTypes
                = Arrays.stream(RewardType.values())
                .filter(rewardType -> rewardType.equals(matched, hasBonus))
                .collect(toList());

        if(rewardTypes.size() == 0){
            return NONE;
        }

        if(rewardTypes.size() >= 2){
            throw new IllegalStateException("매칭되는 보상의 갯수가 2개 이상입니다.");
        }

        return rewardTypes.get(0);
    }
}
