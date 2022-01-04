package lotto.domain.dto;

public class LottoMatchResultOutput {

    private final boolean bonusNumberMatching;
    private final int matchingCount;

    public LottoMatchResultOutput(boolean bonusNumberMatching, int matchingCount) {
        this.bonusNumberMatching = bonusNumberMatching;
        this.matchingCount = matchingCount;
    }

    public boolean getBonusNumberMatching() {
        return bonusNumberMatching;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
