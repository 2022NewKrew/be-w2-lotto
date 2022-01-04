package com.kakao.data;

import com.kakao.model.LottoWinningReward;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningData {
    private LottoWinningData() {}

    public static final List<LottoWinningReward> lottoWinningRewards;

    static {
        lottoWinningRewards = new ArrayList<>();
        lottoWinningRewards.add(generateReward(3, 5000));
        lottoWinningRewards.add(generateReward(4,50000));
        lottoWinningRewards.add(generateReward(5,1500000));
        lottoWinningRewards.add(generateReward(6,2000000000));
    }
    private static LottoWinningReward generateReward(int countOfMatchNumber, int rewardPrice) {
        return new LottoWinningReward(countOfMatchNumber,rewardPrice);
    }
}
