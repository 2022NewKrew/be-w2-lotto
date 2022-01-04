package controller.dto;

import common.model.LottoRank;

import java.util.Map;

public class WinningResult {

    private final Map<LottoRank, Integer> countMap;

    private final Integer profitRatio;

    public WinningResult(Map<LottoRank, Integer> countMap, Integer profitRatio) {
        this.countMap = countMap;
        this.profitRatio = profitRatio;
    }

    public Map<LottoRank, Integer> getCountMap() {
        return countMap;
    }

    public int getProfitRatio() {
        return profitRatio;
    }
}
