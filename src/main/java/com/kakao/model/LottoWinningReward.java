package com.kakao.model;

public class LottoWinningReward {
    int countOfMatchNumber;
    int rewardPrice;
<<<<<<< HEAD
    boolean useBonusBall;
=======
>>>>>>> 4f43f8b (1차 Commit)

    public LottoWinningReward(int countOfMatchNumber, int rewardPrice) {
        this.countOfMatchNumber = countOfMatchNumber;
        this.rewardPrice = rewardPrice;
    }
<<<<<<< HEAD
    public LottoWinningReward(int countOfMatchNumber, int rewardPrice, boolean useBonusBall) {
        this(countOfMatchNumber,rewardPrice);
        this.useBonusBall = useBonusBall;
    }
=======
>>>>>>> 4f43f8b (1차 Commit)

    public int getCountOfMatchNumber() {
        return countOfMatchNumber;
    }
    public int getRewardPrice() {
        return rewardPrice;
    }
}
