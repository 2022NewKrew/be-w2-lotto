package com.kakao.model;

public class LottoWinningReward {
<<<<<<< HEAD
    int countOfMatchNumber;
<<<<<<< HEAD
    int rewardPrice;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 5806f60 (2일차 PR)
    boolean useBonusBall;
=======
>>>>>>> 4f43f8b (1차 Commit)
=======
    boolean useBonusBall;
>>>>>>> 231c634 (1차 PR 리뷰 개선)
=======
    private int countOfMatchNumber;
    private boolean useBonusBall;
>>>>>>> c32dcda (- TestCode 추가)

    public LottoWinningReward(int countOfMatchNumber) {

        this.countOfMatchNumber = countOfMatchNumber;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 231c634 (1차 PR 리뷰 개선)
    public LottoWinningReward(int countOfMatchNumber, int rewardPrice, boolean useBonusBall) {
        this(countOfMatchNumber,rewardPrice);
=======
    public LottoWinningReward(int countOfMatchNumber, boolean useBonusBall) {
        this(countOfMatchNumber);
>>>>>>> 5806f60 (2일차 PR)
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
    public boolean getUseBaseBall() { return this.useBonusBall; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoWinningReward that = (LottoWinningReward) o;

        if (countOfMatchNumber != that.countOfMatchNumber) return false;
        return useBonusBall == that.useBonusBall;
    }

    @Override
    public int hashCode() {
        int result = countOfMatchNumber;
        result = 31 * result + (useBonusBall ? 1 : 0);
        return result;
    }
}
