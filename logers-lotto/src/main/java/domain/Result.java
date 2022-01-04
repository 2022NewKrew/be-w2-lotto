package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {
    private final Map<Integer, Integer> numOfMatchedToReward;
    private final Map<Integer, Integer> numOfMatchedToCount;
    private int purchaseAmount = 0;

    Result(){
        numOfMatchedToReward = Map.of(
                0, 0,
                1, 0,
                2, 0,
                3, 5000,
                4, 50000,
                5, 1500000,
                6, 2000000000
                );

        numOfMatchedToCount = new HashMap<>(){{
            put(0, 0);
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};
    }

    public void addMatched(int numOfMatched){
        purchaseAmount += Lotto.PRICE;

        if(!numOfMatchedToCount.containsKey(numOfMatched)){
            return;
        }

        numOfMatchedToCount.computeIfPresent(numOfMatched, (key, val)-> ++val);
    }

    @Override
    public String toString() {
        return "당첨통계\n"
                .concat("------------\n")
                .concat(numOfMatchedToCount.entrySet().stream()
                        .map(entry -> toStringOneEntry(entry.getKey(), entry.getValue()))
                        .collect(Collectors.joining("\n"))
                ).concat("\n총 수익률은 ")
                .concat(String.valueOf(getTotalReward() / purchaseAmount * 100))
                .concat("%입니다.");
    }

    private String toStringOneEntry(int numOfMatched, int count){
        return String.valueOf(numOfMatched)
                .concat("개 일치 (")
                .concat(String.valueOf(numOfMatchedToReward.get(numOfMatched)))
                .concat(") - ")
                .concat(String.valueOf(count))
                .concat("개");
    }

    private int getTotalReward(){
        return numOfMatchedToCount.entrySet().stream()
                .map(entry -> numOfMatchedToReward.get(entry.getKey()) * entry.getValue())
                .reduce(0, Integer::sum);
    }
}
