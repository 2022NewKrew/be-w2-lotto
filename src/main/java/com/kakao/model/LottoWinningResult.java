package com.kakao.model;

import com.kakao.data.MatchBall;

import java.util.HashMap;
import java.util.Map;

public class LottoWinningResult {
    private final int DEFAULT_NUMBER_OF_COUNT = 0;

    Map<LottoWinningReward, Integer> winningResult; // 해시맵 사용

    public LottoWinningResult() {
        this.winningResult = new HashMap<>();
    }

    public void addCountAndUpdateByKey(LottoWinningReward rewardKey) {
        if(rewardKey == null) {
            return;
        }
        int count = this.winningResult.getOrDefault(rewardKey, DEFAULT_NUMBER_OF_COUNT);
        this.winningResult.put(rewardKey, count+1);
    }

    public int getCount(LottoWinningReward rewardkey) {
        return winningResult.getOrDefault(rewardkey, DEFAULT_NUMBER_OF_COUNT);
    }

    public int getYieldByMatchBall(MatchBall matchBall) {
        LottoWinningReward rewardKey = matchBall.getLottoWinningReward();
        int rewardPrice = matchBall.getRewardPrice();
        int count = winningResult.getOrDefault(rewardKey, DEFAULT_NUMBER_OF_COUNT);
        return rewardPrice * count;
    }
}
