package domain;

import java.util.Arrays;
import java.util.List;
<<<<<<< HEAD

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
=======
import java.util.stream.Collectors;

public enum RewardType {
    THREE_MATCHED(3, 5000),
    FOUR_MATCHED(4, 50000),
    FIVE_MATCHED(5, 1500000),
    SIX_MATCHED(6, 2000000000);

    private final int matchedCount;
    private final int reward;

    RewardType(int matchedCount, int reward) {
        this.matchedCount = matchedCount;
        this.reward = reward;
    }

    public static int getReward(int matchedCount){
        List<RewardType> matchedRewardTypes
                = Arrays.stream(RewardType.values())
                .filter(rewardType -> rewardType.matchedCount == matchedCount)
                .collect(Collectors.toList());

        if(matchedRewardTypes.size() == 0){
            return 0;
        }

        if(matchedRewardTypes.size() >= 2){
            throw new IllegalStateException("매칭되는 보상의 갯수가 2개 이상입니다.");
        }

        return matchedRewardTypes.get(0).reward;
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
    }
}
