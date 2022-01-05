package dto.output;

import domain.RewardType;

import java.util.Map;
import java.util.stream.Collectors;

public class RewardResultDto {
    private final Map<RewardType, Integer> rewardToCount;
    private final int profitPercent;

    public RewardResultDto(Map<RewardType, Integer> rewardToCount, int profitPercent) {
        this.rewardToCount = rewardToCount;
        this.profitPercent = profitPercent;
    }

    @Override
    public String toString() {
        return "당첨통계\n"
                .concat("------------\n")
                .concat(toStringRewardToCount(rewardToCount))
                .concat("\n총 수익률은 ")
                .concat(String.valueOf(profitPercent))
                .concat("%입니다.");
    }

    private static String toStringRewardToCount(Map<RewardType, Integer> rewardToCount){
        return rewardToCount.entrySet().stream()
                .map(entry -> toStringRewardAndCount(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }

    private static String toStringRewardAndCount(RewardType rewardType, int count){
        return rewardType.toString()
                .concat(String.valueOf(count))
                .concat("개");
    }
}
