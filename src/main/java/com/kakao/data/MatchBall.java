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
    private int rewardPrice;

    MatchBall(int countOfMatchNumber, int rewardPrice) {
        this.rewardPrice = rewardPrice;
        this.lottoWinningReward = new LottoWinningReward(countOfMatchNumber);
    }
    MatchBall(int countOfMatchNumber, int rewardPrice, boolean useBonusBall) {
        this.rewardPrice = rewardPrice;
        this.lottoWinningReward = new LottoWinningReward(countOfMatchNumber, useBonusBall);
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 573229f (2일차 PR)

    public int getRewardPrice() {
        return rewardPrice;
    }
    public LottoWinningReward getLottoWinningReward(){
        return lottoWinningReward;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 231c634 (1차 PR 리뷰 개선)
=======
>>>>>>> 573229f (2일차 PR)
=======

>>>>>>> 5806f60 (2일차 PR)
}
