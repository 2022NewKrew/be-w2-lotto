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
                .concat(rewardToCount.entrySet().stream()
                        .map(entry -> toStringOneEntry(entry.getKey(), entry.getValue()))
                        .collect(Collectors.joining("\n"))
                ).concat("\n총 수익률은 ")
                .concat(String.valueOf(profitPercent))
                .concat("%입니다.");
    }

    private String toStringOneEntry(RewardType rewardType, int count){
        return String.valueOf(rewardType.getMatched())
                .concat("개 일치 (")
                .concat(String.valueOf(rewardType.getReward()))
                .concat(") - ")
                .concat(String.valueOf(count))
                .concat("개");
    }
}
