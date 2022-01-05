package domain;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
=======
import java.util.Collections;
import java.util.Map;
import java.util.stream.IntStream;
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)

import static java.util.stream.Collectors.toMap;

public class RewardResult {
    private int purchaseAmount = 0;
<<<<<<< HEAD
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
=======
    private final Map<Integer, Integer> matchedToCount;

    public RewardResult(){
        matchedToCount = IntStream.iterate(0, matched -> matched+1)
                .limit(7)
                .boxed()
                .collect(toMap(matched -> matched, matched -> 0));
    }

    public void addMatched(int numOfMatched){
        purchaseAmount += Lotto.PRICE;
        matchedToCount.computeIfPresent(numOfMatched, (key, val)-> ++val);
    }

    public Map<Integer, Integer> getMatchedToCount() {
        return Collections.unmodifiableMap(matchedToCount);
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
    }

    public int getProfitPercent(){
        return (getTotalReward() - purchaseAmount) / purchaseAmount * 100;
    }

    private int getTotalReward(){
<<<<<<< HEAD
        return rewardToCount.entrySet().stream()
                .map(entry -> entry.getKey().getReward() * entry.getValue())
=======
        return matchedToCount.entrySet().stream()
                .map(entry -> RewardType.getReward(entry.getKey()) * entry.getValue())
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
                .reduce(0, Integer::sum);
    }
}
