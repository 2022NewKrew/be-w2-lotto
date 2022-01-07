package com.david.lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoCalculate {

    private final Map<Rank, Integer> totalCount = new LinkedHashMap<>();

    public LottoCalculate() {
        totalCount.put(Rank.FIFTH, 0);
        totalCount.put(Rank.FOURTH, 0);
        totalCount.put(Rank.THIRD, 0);
        totalCount.put(Rank.SECOND, 0);
        totalCount.put(Rank.FIRST, 0);
    }

    private void addCount(int countOfMatch, boolean matchBonus) {
        if (countOfMatch > 2) {
            Rank rank = Rank.valueOf(countOfMatch, matchBonus);
            int curCount = totalCount.get(rank);
            totalCount.put(rank, curCount + 1);
        }
    }

    private void calculateCount(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber) {
        for (Lotto lotto : lottoList) {
            addCount(lotto.calculateCountOfMatch(winningNumber), lotto.checkBonusNumber(bonusNumber));
        }
    }

    private double calculateRevenue() {
        double revenue = 0;
        for (Rank rank : totalCount.keySet()) {
            revenue += (rank.getWinningMoney() * totalCount.get(rank));
        }
        return revenue;
    }

    public double calculateProfitRate(List<Lotto> lottoList, List<Integer> winningNumber, int count, int bonusNumber) {
        calculateCount(lottoList, winningNumber, bonusNumber);
        double revenue = calculateRevenue();
        int amount = count * LottoMachine.lottoPrice;
        return ((revenue - amount) / amount) * 100;
    }

    private String formatString(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개", rank.getCountOfMatch(), rank.getWinningMoney(), totalCount.get(rank));
        }
        return String.format("%d개 일치 (%d원)- %d개", rank.getCountOfMatch(), rank.getWinningMoney(), totalCount.get(rank));
    }

    @Override
    public String toString() {
        return totalCount.keySet().stream()
                .map(this::formatString)
                .collect(Collectors.joining("\n"));
    }

    public Map<Rank, Integer> getTotalCount() {
        return totalCount;
    }
}
