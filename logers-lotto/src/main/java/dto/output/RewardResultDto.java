package dto.output;

import domain.RewardType;

import java.util.Map;
import java.util.stream.Collectors;

public class RewardResultDto {
    private final Map<Integer, Integer> matchedToCount;
    private final int profitPercent;

    public RewardResultDto(Map<Integer, Integer> matchedToCount, int profitPercent) {
        this.matchedToCount = matchedToCount;
        this.profitPercent = profitPercent;
    }

    @Override
    public String toString() {
        return "당첨통계\n"
                .concat("------------\n")
                .concat(matchedToCount.entrySet().stream()
                        .map(entry -> toStringOneEntry(entry.getKey(), entry.getValue()))
                        .collect(Collectors.joining("\n"))
                ).concat("\n총 수익률은 ")
                .concat(String.valueOf(profitPercent))
                .concat("%입니다.");
    }

    private String toStringOneEntry(int numOfMatched, int count){
        return String.valueOf(numOfMatched)
                .concat("개 일치 (")
                .concat(String.valueOf(RewardType.getReward(numOfMatched)))
                .concat(") - ")
                .concat(String.valueOf(count))
                .concat("개");
    }
}
