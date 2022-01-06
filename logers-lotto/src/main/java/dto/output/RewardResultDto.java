package dto.output;

import domain.RewardType;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class RewardResultDto {
    private final Map<RewardType, Integer> rewardToCount;
    private final int profitPercent;

    public RewardResultDto(Map<RewardType, Integer> rewardToCount, int profitPercent) {
        this.rewardToCount = rewardToCount;
        this.profitPercent = profitPercent;
    }

    public List<String> getRewardResults(){
        return rewardToCount.entrySet().stream()
                .map(entry -> toStringRewardAndCount(entry.getKey(), entry.getValue()))
                .collect(toList());
    }

    public int getProfitPercent() {
        return profitPercent;
    }

    private static String toStringRewardAndCount(RewardType rewardType, int count){
        return rewardType.toString()
                .concat(String.valueOf(count))
                .concat("개");
    }
}
