package domain;

import view.LottoOutput;

import java.util.Map;
import java.util.TreeMap;

public class WinningStats {
    private final Map<Ranking, Long> prizeMap = new TreeMap<>();
    private final long winningPrize;

    public WinningStats(long winningPrize) {
        this.winningPrize = winningPrize;
    }

    public void addStats(Ranking ranking, long num) {
        if (ranking != Ranking.NONE) {
            prizeMap.put(ranking, num);
        }
    }

    public void printMap() {
        prizeMap.forEach((ranking, count) ->
                System.out.printf((LottoOutput.PRIZE_STR_FORMAT) + "%n", ranking.getMatchCount(), ranking.getWiningPrize(), count));
    }

    public double getTotalIncome(int buyPrice) {
        return ((double) (winningPrize - buyPrice)) * 100 / buyPrice;
    }
}
