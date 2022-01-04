package lotto.domain;

class LottoMatchResult {
    private final int count;
    private final boolean isBonusBall;

    public LottoMatchResult(int count, boolean isBonusBall) {
        this.count = count;
        this.isBonusBall = isBonusBall;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonusBall() {
        return isBonusBall;
    }
}