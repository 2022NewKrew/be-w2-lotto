package carrot.ez.dto;

import carrot.ez.lotto.Rank;

import java.util.Map;

public class LotteryStatisticsDto {
    private final Map<Rank, Long> rankCountMap;
    private final Long sum;

    public LotteryStatisticsDto(Map<Rank, Long> rankCountMap, Long sum) {
        this.rankCountMap = rankCountMap;
        this.sum = sum;
    }

    public Long getRankCount(Rank rank) {
        return rankCountMap.getOrDefault(rank, 0L);
    }

    public Long getSum() {
        return sum;
    }
}
