package com.kakao.model;

public class LottoWinningReward {
    int countOfMatchNumber;
    int rewardPrice;
<<<<<<< HEAD
<<<<<<< HEAD
    boolean useBonusBall;
=======
>>>>>>> 4f43f8b (1차 Commit)
=======
    boolean useBonusBall;
>>>>>>> 231c634 (1차 PR 리뷰 개선)

    public LottoWinningReward(int countOfMatchNumber, int rewardPrice) {
        this.countOfMatchNumber = countOfMatchNumber;
        this.rewardPrice = rewardPrice;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 231c634 (1차 PR 리뷰 개선)
    public LottoWinningReward(int countOfMatchNumber, int rewardPrice, boolean useBonusBall) {
        this(countOfMatchNumber,rewardPrice);
        this.useBonusBall = useBonusBall;
    }
<<<<<<< HEAD
=======
>>>>>>> 4f43f8b (1차 Commit)
=======
>>>>>>> 231c634 (1차 PR 리뷰 개선)

    public int getCountOfMatchNumber() {
        return countOfMatchNumber;
    }
    public int getRewardPrice() {
        return rewardPrice;
    }
}
