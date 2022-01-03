package model.datastructure;

import java.util.ArrayList;
import java.util.List;

public class LottoMatchStateDTO {
    private final ArrayList<Integer> matchNumbers;
    private int moneyTotalCost = 0;
    private int moneyTotalWin = 0;

    public LottoMatchStateDTO() {
        this.matchNumbers = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0));
    }

    public int get(int i) {
        return matchNumbers.get(i);
    }

    public void addMatch(int i) {
        matchNumbers.set(i, matchNumbers.get(i) + 1);
    }

    public void setMoneyTotalCost(int money) {
        moneyTotalCost = money;
    }

    public int getMoneyTotalCost() {
        return moneyTotalCost;
    }
    public void addMoneyTotalWin(int money) {
        moneyTotalWin = moneyTotalWin + money;
    }

    public int getMoneyTotalWin() {
        return moneyTotalWin;
    }
}
