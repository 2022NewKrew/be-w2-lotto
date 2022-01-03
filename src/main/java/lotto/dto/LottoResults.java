package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {
    static List<Integer> correctCnts = new ArrayList<>(4);
    static int earnRate;

    public LottoResults() {
    }

    public LottoResults(List<Integer> correctCnts, int earnRate) {
        this.correctCnts = correctCnts;
        this.earnRate = earnRate;
    }

    public List<Integer> getCorrectCnts() {
        return this.correctCnts;
    }

    public int getEarnRate() {
        return this.earnRate;
    }
}
