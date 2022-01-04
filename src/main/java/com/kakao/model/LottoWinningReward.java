package com.kakao.model;

public class LottoWinningReward {
    int countOfMatchNumber;
    int rewardPrice;
    boolean useBonusBall;

    public LottoWinningReward(int countOfMatchNumber, int rewardPrice) {
        this.countOfMatchNumber = countOfMatchNumber;
        this.rewardPrice = rewardPrice;
    }
    public LottoWinningReward(int countOfMatchNumber, int rewardPrice, boolean useBonusBall) {
        this(countOfMatchNumber,rewardPrice);
        this.useBonusBall = useBonusBall;
    }

    public int getCountOfMatchNumber() {
        return countOfMatchNumber;
    }
    public int getRewardPrice() {
        return rewardPrice;
    }
}
