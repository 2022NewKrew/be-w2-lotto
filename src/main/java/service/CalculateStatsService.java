package service;

import VO.StatsVO;
import domain.Lotto;
import domain.Rank;

import java.util.*;

public class CalculateStatsService {
    public StatsVO calculateStats(List<Lotto> lottoList, Lotto winningLotto) {
        Map<Rank, Integer> stats = new HashMap<>();
        for (Lotto lotto : lottoList) {
            Rank rank = calculateRankOfLotto(lotto, winningLotto);
            modifyStats(stats, rank);
        }
        long totalPrizeMoney = calculateTotalPrizeMoney(stats);
        return new StatsVO(stats, totalPrizeMoney);
    }

    private Rank calculateRankOfLotto(Lotto lotto, Lotto winningLotto) {
        Set<Integer> sameNumbers = new HashSet<>();
        sameNumbers.addAll(new HashSet<>(lotto.getNumbers()));
        sameNumbers.retainAll((new HashSet<>(winningLotto.getNumbers())));
        int countOfMatch = sameNumbers.size();
        boolean matchBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private void modifyStats(Map<Rank, Integer> winningStats, Rank rank) {
        if (rank != null) {
            winningStats.put(rank, winningStats.getOrDefault(rank, 0) + 1);
        }
    }

    private long calculateTotalPrizeMoney(Map<Rank, Integer> stats) {
        long totalPrizeMoney = 0;
        for (Rank rank : stats.keySet()) {
            totalPrizeMoney += rank.getWinningMoney() * stats.getOrDefault(rank, 0);
        }
        return totalPrizeMoney;
    }
}
