package domain;

import java.util.Arrays;
import java.util.List;
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
    }
}
