package com.upperleaf.domain;

import com.upperleaf.domain.lotto.LottoRanking;

import java.util.Map;

public class LottoResult {
    private final Map<LottoRanking, Long> groupLottoRanking;
    private final long profitRate;

    private Long id;
    private Long lottosId;

    public LottoResult(Map<LottoRanking, Long> groupLottoRanking, long profitRate) {
        this.groupLottoRanking = groupLottoRanking;
        this.profitRate = profitRate;
    }

    public long getProfitRate() {
        return profitRate;
    }

    public Map<LottoRanking, Long> getGroupLottoRanking() {
        return groupLottoRanking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLottosId() {
        return lottosId;
    }

    public void setLottoId(Long lottosId) {
        this.lottosId = lottosId;
    }
}
