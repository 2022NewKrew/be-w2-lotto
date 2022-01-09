package lotto.result;

import lotto.configure.LottoConfigure;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<LottoRank, Integer> resultMap;

    private int totalLottoCount;

    private int totalPurchaseAmount;

    private int totalReward;

    private String message;

    private String totalRateOfReturn;

    public LottoResult() {
        this.resultMap = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }
        message = "";
    }

    public Map<LottoRank, Integer> getResultMap() {
        return resultMap;
    }

    public int getRankCount(LottoRank rank) {
        return resultMap.get(rank);
    }

    public void addMessage(String message) {
        this.message += message;
    }

    public String getMessage() {
        return message;
    }

    public String getTotalRateOfReturn() {
        return totalRateOfReturn;
    }

    public void setTotalRateOfReturn(double rate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        totalRateOfReturn = decimalFormat.format(rate);
    }

    public double getYield() {
        if (totalPurchaseAmount == 0) return 0.0;
        return (double)(totalReward - totalPurchaseAmount)/(double)totalPurchaseAmount * 100;
    }

    public void putLottoRank(LottoRank lottoRank){
        resultMap.put(lottoRank, resultMap.get(lottoRank) + 1);
        totalLottoCount += 1;
        totalPurchaseAmount += LottoConfigure.LOTTO_PRICE;
        totalReward += lottoRank.getWinningMoney();
        setTotalRateOfReturn(getYield());
    }
}
