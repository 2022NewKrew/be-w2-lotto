package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class RewardResult {
    private int purchaseAmount = 0;
    private final Map<RewardType, Integer> rewardToCount;

    public RewardResult(){
        rewardToCount = Arrays.stream(RewardType.values())
                .collect(toMap(rewardType -> rewardType, rewardType -> 0));
    }

    public void addMatched(RewardType rewardType){
        purchaseAmount += Lotto.PRICE;
        rewardToCount.computeIfPresent(rewardType, (key, val)-> ++val);
    }

    public Map<RewardType, Integer> getRewardToCount() {
        return Collections.unmodifiableMap(rewardToCount);
    }

    public int getProfitPercent(){
        return (getTotalReward() - purchaseAmount) / purchaseAmount * 100;
    }

    private int getTotalReward(){
        return rewardToCount.entrySet().stream()
                .map(entry -> entry.getKey().getReward() * entry.getValue())
                .reduce(0, Integer::sum);
    }
}
