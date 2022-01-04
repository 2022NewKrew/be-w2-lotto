package dto;

import java.util.ArrayList;
import java.util.HashMap;

public class LottoMatchStateDTO {
    private final ArrayList<Integer> numStaticsByRank;
    private final int numOfWinRanks;
    private int moneyTotalCost = 0;
    private int moneyTotalWin = 0;
    private HashMap<Integer, Integer> winPriceByRank;
    private HashMap<Integer, String> winMessageByRank;

    public void setWinPriceByRank(HashMap<Integer, Integer> winPriceByRank) {
        this.winPriceByRank = winPriceByRank;
    }

    public void setWinMessageByRank(HashMap<Integer, String> winMessageByRank) {
        this.winMessageByRank = winMessageByRank;
    }

    public LottoMatchStateDTO(int numOfWinRanks) {
        this.numOfWinRanks = numOfWinRanks;
        this.numStaticsByRank = new ArrayList<>(numOfWinRanks + 1);
        for (int i = 0; i <= numOfWinRanks; i++) {
            this.numStaticsByRank.add(0);
        }
    }

    public int get(int rank) {
        return numStaticsByRank.get(rank);
    }

    public void addMatch(int rank) {
        numStaticsByRank.set(rank, numStaticsByRank.get(rank) + 1);
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

    public ArrayList<Integer> getNumStaticsByRank() {
        return numStaticsByRank;
    }

    public int getNumOfWinRanks() {
        return numOfWinRanks;
    }

    public HashMap<Integer, Integer> getWinPriceByRank() {
        return winPriceByRank;
    }

    public HashMap<Integer, String> getWinMessageByRank() {
        return winMessageByRank;
    }
}
