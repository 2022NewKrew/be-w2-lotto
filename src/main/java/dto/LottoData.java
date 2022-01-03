package dto;

import java.util.ArrayList;
import java.util.List;

public class LottoData {
    private int budget;
    private int revenue;
    private final List<Integer> winningNumbers = new ArrayList<>();

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers.addAll(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
