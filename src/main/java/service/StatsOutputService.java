package service;

import domain.Rank;
import view.OutputView;

import java.util.*;

public class StatsOutputService {
    public void printStats(Map<Rank, Integer> stats) {
        OutputView.printLabel(String.format("\n당첨 통계\n---------"));

        List<String> statsStringList = new ArrayList<>();
        List<Rank> rankList = Arrays.asList(Rank.values());
        Collections.reverse(rankList);
        for (Rank rank : rankList) {
            statsStringList.add(rankString(stats, rank));
        }
        OutputView.printStatsStringList(statsStringList);
    }

    private String rankString(Map<Rank, Integer> stats, Rank rank) {
        if (rank.name().equals("SECOND")) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개",
                    rank.getCountOfMatch(),rank.getWinningMoney(),stats.getOrDefault(rank, 0));
        }
        return String.format("%d개 일치 (%d원)- %d개",
                rank.getCountOfMatch(),rank.getWinningMoney(),stats.getOrDefault(rank, 0));
    }

    public void printYield(int money, long totalPrizeMoney) {
        double yield = (totalPrizeMoney - money) / (double) money * 100;
        OutputView.printLabel(String.format("총 수익률은 %.2f%%입니다.", yield));
    }
}
