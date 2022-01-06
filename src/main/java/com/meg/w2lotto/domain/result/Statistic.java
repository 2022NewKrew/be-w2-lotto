package com.meg.w2lotto.domain.result;

import java.util.EnumMap;
import java.util.Map;

public class Statistic {

    private static final Map<Prize, Integer> correctCounts = new EnumMap<>(Prize.class);
    private final int purchaseMoney;
    private int totalReturn;

    static {
        for (Prize prize : Prize.values()) {
            correctCounts.put(prize, 0);
        }
    }

    public Statistic(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        calculateTotalReturn();
    }

    public Map<Prize, Integer> getCorrectCounts() {
        return correctCounts;
    }

    public void addUpCorrectCounts(Prize prize) {
        correctCounts.put(prize, correctCounts.get(prize)+1);
    }

    private void calculateTotalReturn() {
        int total = 0;
        for (Map.Entry<Prize, Integer> entry : correctCounts.entrySet()) {
            total += (entry.getKey().getWinningMoney() * entry.getValue());
        }
        totalReturn = (total - purchaseMoney) / purchaseMoney * 100;
    }

    public int getTotalReturn() {
        return totalReturn;
    }
}
