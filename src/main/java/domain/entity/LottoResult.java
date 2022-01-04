package domain.entity;

public class LottoResult {
    private final int matchedNums;
    private final boolean isBonusNumMatched;

    public LottoResult(int matchedNums, boolean isBonusNumMatched) {
        this.matchedNums = matchedNums;
        this.isBonusNumMatched = isBonusNumMatched;
    }

    public int getMatchedNums() {
        return matchedNums;
    }

    public boolean isBonusNumMatched() {
        return isBonusNumMatched;
    }
}
