package com.kakao.model;

public class LottoWinningReward {
    int countOfMatchNumber;
    int rewardPrice;

    public LottoWinningReward(int countOfMatchNumber, int rewardPrice) {
        this.countOfMatchNumber = countOfMatchNumber;
        this.rewardPrice = rewardPrice;
    }

    public int getCountOfMatchNumber() {
        return countOfMatchNumber;
    }
    public int getRewardPrice() {
        return rewardPrice;
    }
}
