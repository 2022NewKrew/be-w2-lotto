package com.kakao.data;

import com.kakao.model.LottoWinningReward;

public enum MatchBall {
    MATCH_THREE(3, 5000),
    MATCH_FOUR(4,50000),
    MATCH_FIVE(5,1500000),
    MATCH_FIVE_WITH_BONUS(5,30000000, true),
    MATCH_SIX(6,2000000000),
    ;

    private final LottoWinningReward lottoWinningReward;
    private final int rewardPrice;

    MatchBall(int countOfMatchNumber, int rewardPrice) {
        this.rewardPrice = rewardPrice;
        this.lottoWinningReward = new LottoWinningReward(countOfMatchNumber);
    }
    MatchBall(int countOfMatchNumber, int rewardPrice, boolean useBonusBall) {
        this.rewardPrice = rewardPrice;
        this.lottoWinningReward = new LottoWinningReward(countOfMatchNumber, useBonusBall);
    }

    public int getRewardPrice() {
        return rewardPrice;
    }
    public LottoWinningReward getLottoWinningReward(){
        return lottoWinningReward;
    }
}
