package com.upperleaf.web.dto;

import com.upperleaf.domain.lotto.LottoRanking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatisticsInfo {

    private final List<String> message;
    private final long totalRateOfReturn;


    public LottoStatisticsInfo(Map<LottoRanking, Long> groupRanking, long profitRate) {
        this.message = makeMessage(groupRanking);
        this.totalRateOfReturn = profitRate;
    }

    private List<String> makeMessage(Map<LottoRanking, Long> groupRanking) {
        return Arrays.stream(LottoRanking.values()).map(ranking -> {
            long count = groupRanking.getOrDefault(ranking, 0L);
            if (ranking.isMatchedBonus()) {
                return ranking.getMatchNumber() + "개 일치, 보너스 볼 일치 (" + ranking.getWinningPrice() + "원)- " + count + "개";
            }
            return ranking.getMatchNumber() + "개 일치 (" + ranking.getWinningPrice() + "원)- " + count + "개";
        }).collect(Collectors.toUnmodifiableList());
    }

    public List<String> getMessage() {
        return message;
    }

    public long getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
