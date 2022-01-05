package domain;

import java.util.Arrays;
import java.util.List;


import static java.util.stream.Collectors.toList;

public enum RewardType {
    NONE(0, false, 0),
    FOURTH_PLACE(4, false, 5_000),
    THIRD_PLACE(5, false, 50_000),
    SECOND_PLACE(5, true, 1_500_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    private final int matched;
    private final boolean hasBonus;
    private final long reward;

    RewardType(int matched, boolean hasBonus, long reward) {
        this.matched = matched;
        this.hasBonus = hasBonus;
        this.reward = reward;
    }

    public long getReward() {
        return reward;
    }

    public boolean equals(int matched, boolean hasBonus){
        if(this.matched != SECOND_PLACE.matched){
            return this.matched == matched;
        }

        return this.matched == matched && this.hasBonus == hasBonus;
    }

    public static RewardType of(int matched, boolean hasBonus) {
        List<RewardType> rewardTypes
                = Arrays.stream(RewardType.values())
                .filter(rewardType -> rewardType.equals(matched, hasBonus))
                .collect(toList());

        if (rewardTypes.size() == 0) {
            return NONE;
        }

        if (rewardTypes.size() >= 2) {
            throw new IllegalStateException("매칭되는 보상의 갯수가 2개 이상입니다.");
        }

        return rewardTypes.get(0);
    }

    @Override
    public String toString() {
        return String.valueOf(matched)
                .concat("개 일치 (")
                .concat(String.valueOf(reward))
                .concat(") - ");
    }
}
