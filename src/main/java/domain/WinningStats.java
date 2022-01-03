package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinningStats {
    private final HashMap<Integer, Integer> winningStats = new HashMap<>();

    public WinningStats(List<Lotto> allLotto, List<Integer> winningNumbers) {
        calculateWinningStats(allLotto, winningNumbers);
    }

    private void calculateWinningStats(List<Lotto> allLotto, List<Integer> winningNumbers) {
        setUpWinningStats();
        for (Lotto lotto : allLotto) {
            calculateWinningStatsOfOneLotto(lotto, winningNumbers);
        }
    }

    private void setUpWinningStats() {
        for (int i = 0 ; i <= 6 ; i++) {
            winningStats.put(i, 0);
        }
    }

    private void calculateWinningStatsOfOneLotto(Lotto lotto, List<Integer> winningNumbers) {
        int countOfMatchedNumbers = 0;
        for (int winningNumber : winningNumbers) {
            countOfMatchedNumbers += hasNumberInLotto(lotto.getNumbers(), winningNumber);
        }
        winningStats.replace(countOfMatchedNumbers, winningStats.get(countOfMatchedNumbers) + 1);
    }

    private int hasNumberInLotto(List<Integer> lottoNumbers, int winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    public List<String> toStringArrayList() {
        List<String> winningStatsStrings = new ArrayList<>();
        winningStatsStrings.add("3개 일치 (5000원)- " + winningStats.get(3) + "개");
        winningStatsStrings.add("4개 일치 (50000원)- " + winningStats.get(4) + "개");
        winningStatsStrings.add("5개 일치 (1500000원)- " + winningStats.get(5) + "개");
        winningStatsStrings.add("6개 일치 (2000000000원)- " + winningStats.get(6) + "개");
        return winningStatsStrings;
    }
}
