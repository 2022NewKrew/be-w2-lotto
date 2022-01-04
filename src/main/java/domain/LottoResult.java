package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> countOfMatches;
    private double profitRate;

    public LottoResult() {
        this.countOfMatches = new HashMap<>();
        this.profitRate = 0.0;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public void setCountOfMatches(Map<LottoRank, Integer> countOfMatches) {
        this.countOfMatches = countOfMatches;
    }

    public Map<LottoRank, Integer> getCountOfMatches() {
        return countOfMatches;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
