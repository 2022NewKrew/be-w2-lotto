package com.upperleaf.web.dto;

import com.upperleaf.domain.LottoResult;
import com.upperleaf.domain.lotto.LottoRanking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatisticsInfo {

    private final List<String> message;
    private final long totalRateOfReturn;

    public LottoStatisticsInfo(LottoResult lottoResult) {
        this.message = makeMessage(lottoResult.getGroupLottoRanking());
        this.totalRateOfReturn = lottoResult.getProfitRate();
    }

    private List<String> makeMessage(Map<LottoRanking, Long> groupRanking) {
        return Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking != LottoRanking.NONE)
                .map(ranking -> makeMessageByBonus(ranking, groupRanking.getOrDefault(ranking, 0L)))
                .collect(Collectors.toUnmodifiableList());
    }

    private String makeMessageByBonus(LottoRanking ranking, long count) {
        if (ranking.isMatchedBonus()) {
            return ranking.getMatchNumber() + "개 일치, 보너스 볼 일치 (" + ranking.getWinningPrice() + "원)- " + count + "개";
        }
        return ranking.getMatchNumber() + "개 일치 (" + ranking.getWinningPrice() + "원)- " + count + "개";
    }

    public List<String> getMessage() {
        return message;
    }

    public long getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
