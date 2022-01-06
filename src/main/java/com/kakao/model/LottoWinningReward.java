package com.kakao.model;

public class LottoWinningReward {
    private int countOfMatchNumber;
    private boolean useBonusBall;

    public LottoWinningReward(int countOfMatchNumber) {

        this.countOfMatchNumber = countOfMatchNumber;
    }

    public LottoWinningReward(int countOfMatchNumber, boolean useBonusBall) {
        this(countOfMatchNumber);
        this.useBonusBall = useBonusBall;
    }

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
