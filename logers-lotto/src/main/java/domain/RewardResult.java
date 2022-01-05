package domain;


import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class RewardResult {
    private int purchaseAmount = 0;
    private final Map<RewardType, Integer> rewardToCount;

    public RewardResult(List<RewardType> rewards){
        rewardToCount = createRewardToCount();
        addMatchedAll(rewards);
    }

    public static EnumMap<RewardType, Integer> createRewardToCount(){
        return Arrays.stream(RewardType.values())
                .collect(toMap(Function.identity(), rewardType -> 0,
                        (rewardType1, rewardType2) -> rewardType1,
                        ()->new EnumMap<>(RewardType.class)));
    }

    private void addMatchedAll(List<RewardType> rewardTypes){
        for(RewardType rewardType : rewardTypes){
            addMatched(rewardType);
        }
    }

    private void addMatched(RewardType rewardType){
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
