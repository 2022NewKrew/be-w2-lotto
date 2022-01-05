package dto.output;

import domain.RewardType;

import java.util.Map;
import java.util.stream.Collectors;

public class RewardResultDto {
<<<<<<< HEAD
    private final Map<RewardType, Integer> rewardToCount;
    private final int profitPercent;

    public RewardResultDto(Map<RewardType, Integer> rewardToCount, int profitPercent) {
        this.rewardToCount = rewardToCount;
=======
    private final Map<Integer, Integer> matchedToCount;
    private final int profitPercent;

    public RewardResultDto(Map<Integer, Integer> matchedToCount, int profitPercent) {
        this.matchedToCount = matchedToCount;
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
        this.profitPercent = profitPercent;
    }

    @Override
    public String toString() {
        return "당첨통계\n"
                .concat("------------\n")
<<<<<<< HEAD
                .concat(rewardToCount.entrySet().stream()
=======
                .concat(matchedToCount.entrySet().stream()
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
                        .map(entry -> toStringOneEntry(entry.getKey(), entry.getValue()))
                        .collect(Collectors.joining("\n"))
                ).concat("\n총 수익률은 ")
                .concat(String.valueOf(profitPercent))
                .concat("%입니다.");
    }

<<<<<<< HEAD
    private String toStringOneEntry(RewardType rewardType, int count){
        return String.valueOf(rewardType.getMatched())
                .concat("개 일치 (")
                .concat(String.valueOf(rewardType.getReward()))
=======
    private String toStringOneEntry(int numOfMatched, int count){
        return String.valueOf(numOfMatched)
                .concat("개 일치 (")
                .concat(String.valueOf(RewardType.getReward(numOfMatched)))
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
                .concat(") - ")
                .concat(String.valueOf(count))
                .concat("개");
    }
}
