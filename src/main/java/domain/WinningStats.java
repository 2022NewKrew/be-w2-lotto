package domain;

import java.util.*;

public class WinningStats {
    private final HashMap<Rank, Integer> winningStats = new HashMap<>();

    public WinningStats(List<PurchasedLotto> allLotto, List<Integer> winningNumbers, Integer bonusNumber) {
        calculateWinningStats(allLotto, winningNumbers, bonusNumber);
    }

    private void calculateWinningStats(List<PurchasedLotto> allLotto, List<Integer> winningNumbers, Integer bonusNumber) {
        for (PurchasedLotto lotto : allLotto) {
            calculateWinningStatsOfOneLotto(lotto, winningNumbers, bonusNumber);
        }
    }

    private void calculateWinningStatsOfOneLotto(PurchasedLotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        Set<Integer> lottoWinningIntersectionSet = new HashSet<>(new HashSet<>(lotto.getNumbers()));
        lottoWinningIntersectionSet.retainAll(new HashSet<>(winningNumbers));
        int countOfMatch = lottoWinningIntersectionSet.size();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);
        if (rank != null) {
            winningStats.put(rank, winningStats.getOrDefault(rank, 0) + 1);
        }
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
        if (rank.name().equals("SECOND")) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개",
                    rank.getCountOfMatch(),rank.getWinningMoney(),winningStats.getOrDefault(rank, 0));
        }
        return String.format("%d개 일치 (%d원)- %d개",
                rank.getCountOfMatch(),rank.getWinningMoney(),winningStats.getOrDefault(rank, 0));
    }
}
