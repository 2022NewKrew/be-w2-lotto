package view.dto;

import java.util.Map;

public class WinningResultResponse {

    private final Map<Integer, Integer> lottoResultCountMap;

    private final double profitRatio;

    public WinningResultResponse(Map<Integer, Integer> lottoResultCountMap, double profitRatio) {
        this.lottoResultCountMap = lottoResultCountMap;
        this.profitRatio = profitRatio;
    }

    public Map<Integer, Integer> getLottoResultCountMap() {
        return lottoResultCountMap;
    }

    public double getProfitRatio() {
        return profitRatio;
    }

}
