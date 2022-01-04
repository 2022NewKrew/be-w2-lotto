package view.dto;

import view.model.WinningStatisticalData;

import java.util.List;

public class WinningResultResponse {

    private final List<WinningStatisticalData> winningStatisticalDataList;

    private final Integer profitRatio;

    public WinningResultResponse(List<WinningStatisticalData> winningStatisticalDataList, Integer profitRatio) {
        this.winningStatisticalDataList = winningStatisticalDataList;
        this.profitRatio = profitRatio;
    }

    public List<WinningStatisticalData> getWinningStatisticalDataList() {
        return winningStatisticalDataList;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
