package lotto.result;

import lotto.configure.LottoConfigure;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<LottoRank, Integer> resultMap;

    private int totalLottoCount;

    private int totalPurchaseAmount;

    private int totalReward;

    public LottoResult() {
        this.resultMap = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public Map<LottoRank, Integer> getResultMap() {
        return resultMap;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }

    public int getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public int getTotalReward() {
        return totalReward;
    }

    public void putLottoRank(LottoRank lottoRank){
        resultMap.put(lottoRank, resultMap.get(lottoRank) + 1);
        totalLottoCount += 1;
        totalPurchaseAmount += LottoConfigure.LOTTO_PRICE;
        totalReward += lottoRank.getWinningMoney();
    }
}
