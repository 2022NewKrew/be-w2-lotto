package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

public class WinningStats {
    private final HashMap<Rank, Integer> winningStats = new HashMap<>();

    public WinningStats(List<Lotto> allLotto, List<Integer> winningNumbers, Integer bonusNumber) {
        calculateWinningStats(allLotto, winningNumbers, bonusNumber);
    }

    private void calculateWinningStats(List<Lotto> allLotto, List<Integer> winningNumbers, Integer bonusNumber) {
        for (Lotto lotto : allLotto) {
            calculateWinningStatsOfOneLotto(lotto, winningNumbers, bonusNumber);
        }
    }

    private void calculateWinningStatsOfOneLotto(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        int countOfMatch = 0;
        for (int winningNumber : winningNumbers) {
            countOfMatch += hasNumberInLotto(lotto.getNumbers(), winningNumber);
        }
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);
        if (rank != null) {
            winningStats.put(rank, winningStats.getOrDefault(rank, 0) + 1);
        }
    }

    private int hasNumberInLotto(List<Integer> lottoNumbers, int winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    public int getEarnedMoney() {
        int earnedMoney = 0;
        for (Rank rank : winningStats.keySet()) {
            earnedMoney += rank.getWinningMoney() * winningStats.getOrDefault(rank, 0);
        }
        return earnedMoney;
    }

    public List<String> toStringArrayList() {
        List<String> winningStatsStrings = new ArrayList<>();
        List<Rank> rankList = Arrays.asList(Rank.values());
        Collections.reverse(rankList);
        for (Rank rank : rankList) {
            winningStatsStrings.add(rankString(rank));
        }
        return winningStatsStrings;
    }

    private String rankString(Rank rank) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rank.getCountOfMatch()).append("개 일치");
        if (rank.name().equals("SECOND")) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append("(").append(rank.getWinningMoney()).append("원)- ");
        stringBuilder.append(winningStats.get(rank)).append("개");
        return stringBuilder.toString();
    }
}
