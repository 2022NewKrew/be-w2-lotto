package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class WinningInfo {
    private final HashMap<Rank, Integer> winCount;
    private final int bonusNumber;
    private int returnAmount;

    public WinningInfo(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber) {
        this.winCount = new HashMap<>();
        this.bonusNumber = bonusNumber;
        this.returnAmount = 0;
        initializeWinCount(lottoList, winningNumber);
        initializeReturnAmount();
    }

    public HashMap<Rank, Integer> getWinCount() { return this.winCount; }

    public int getReturnAmount() {
        return this.returnAmount;
    }

    private void initializeWinCount(List<Lotto> lottoList, List<Integer> winningNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.isWin()) this.winCount.put(rank, 0);
        }
        for (Lotto lotto : lottoList) {
            addWinCount(lotto, winningNumber, bonusNumber);
        }
    }

    private void initializeReturnAmount() {
        for (Rank rank : Rank.values()) {
            if (rank.isWin()) this.returnAmount += rank.getWinningMoney() * this.winCount.get(rank);
        }
    }

    private void addWinCount(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchCount = compare(lotto, winningNumber);
        boolean isBonusContained = lotto.getNumbers().contains(bonusNumber);
        Rank result = Rank.valueOf(matchCount, isBonusContained);
        if (result.isWin()) {
            this.winCount.put(result, this.winCount.get(result) + 1);
        }
    }

    private int compare(Lotto lotto, List<Integer> winningNumber) {
        return (int) winningNumber.stream()
                .filter(n -> lotto.getNumbers().contains(n))
                .count();
    }
}
