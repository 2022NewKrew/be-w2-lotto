package domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class RewardResult {
    private int purchaseAmount = 0;
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
    }

    public int getProfitPercent(){
        return (getTotalReward() - purchaseAmount) / purchaseAmount * 100;
    }

    private int getTotalReward(){
        return matchedToCount.entrySet().stream()
                .map(entry -> RewardType.getReward(entry.getKey()) * entry.getValue())
                .reduce(0, Integer::sum);
    }
}
