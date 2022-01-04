package lotto.domain;

import lotto.constant.LottoRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

public class LottoStatistic {
    int lottoCount;
    int profitPercentage;

    Map<Integer, Long> winningCountMap;
    List<Lotto> userLottos;
    Lotto pastWinningLotto;
    LottoRank[] lottoRanks;

    public LottoStatistic() {
        lottoRanks = LottoRank.values();
        winningCountMap = new HashMap<Integer, Long>();
        for (LottoRank lottoRank : lottoRanks) {
            winningCountMap.put(lottoRank.getMatch(), (long)0);
        }
    }

    public void initialize(List<Lotto> userLottos, Lotto pastWinningLotto) {
        this.lottoCount = userLottos.size();
        this.userLottos = userLottos;
        this.pastWinningLotto = pastWinningLotto;
        for (Lotto userLotto : userLottos) {
            int equalCount;
            equalCount = Lotto.calculateEqualCount(userLotto, pastWinningLotto);
            winningCountMap.put(equalCount, winningCountMap.containsKey(equalCount) ? winningCountMap.get(equalCount) + 1 : 0);
        }
        calculateProfitPercentage();
    }

    private void calculateProfitPercentage() {
        long profitTotal = 0;
        long cost = lottoCount * LOTTO_PRICE;
        profitPercentage = (int)((profitTotal - cost) * 100 / cost);
    }

    public Map<Integer, Long> getWinningCountMap() {
        return winningCountMap;
    }

    public int getProfitPercentage() {
        return profitPercentage;
    }
}
