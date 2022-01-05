package domain;


import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class RewardResult {
    private int purchaseAmount = 0;

    private final Map<RewardType, Integer> rewardToCount;

    public RewardResult(){
        rewardToCount = Arrays.stream(RewardType.values())
                .collect(toMap(rewardType -> rewardType, rewardType -> 0
                        ,(rewardType1, rewardType2) -> rewardType1
                        ,()->new EnumMap<>(RewardType.class)));
    }

    public void addMatched(RewardType rewardType){
        purchaseAmount += Lotto.PRICE;
        rewardToCount.computeIfPresent(rewardType, (key, val)-> ++val);
    }


    public Map<RewardType, Integer> getRewardToCount() {
        return Collections.unmodifiableMap(rewardToCount);
    }

    public int getProfitPercent(){
        return (int) ((getTotalReward() - purchaseAmount) / purchaseAmount * 100);
    }

    private long getTotalReward(){
        return rewardToCount.entrySet().stream()
                .map(entry -> entry.getKey().getReward() * entry.getValue())
                .reduce(0L, Long::sum);
    }
}
