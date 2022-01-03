package domain;

import java.util.List;
import java.util.Map;

public class LottoResult {
    private List<Integer> numbers;
    private Map<Integer, Integer> countOfMatches;
    private double profitRate;

    public LottoResult(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public void setCountOfMatches(Map<Integer, Integer> countOfMatches) {
        this.countOfMatches = countOfMatches;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Map<Integer, Integer> getCountOfMatches() {
        return countOfMatches;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
