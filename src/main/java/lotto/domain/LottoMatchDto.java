package lotto.domain;

class LottoMatchDto {
    private final int count;
    private final boolean isBonusBall;

    public LottoMatchDto(int count, boolean isBonusBall) {
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