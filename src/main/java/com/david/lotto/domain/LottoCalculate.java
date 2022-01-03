package com.david.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoCalculate {

    private static final Map<Integer, Integer> winningPrice = new HashMap<>();
    private final Map<Integer, Integer> totalCount = new HashMap<>();
    private double income;

    public LottoCalculate() {
        totalCount.put(3, 0);
        totalCount.put(4, 0);
        totalCount.put(5, 0);
        totalCount.put(6, 0);
        winningPrice.put(3, 5000);
        winningPrice.put(4, 50000);
        winningPrice.put(5, 1500000);
        winningPrice.put(6, 2000000000);
    }

    private void addCount(int containCount) {
        if (containCount > 2) {
            int curCount = totalCount.get(containCount);
            totalCount.put(containCount, curCount + 1);
        }
    }

    private void calculateCount(List<Lotto> lottoList, List<Integer> winningNumber) {
        for (Lotto lotto : lottoList) {
            addCount(lotto.calculateContain(winningNumber));
        }
    }

    private void calculateIncome() {
        for (int key : totalCount.keySet()) {
            income += (winningPrice.get(key) * totalCount.get(key));
        }
    }

    public double calculateProfitRate(List<Lotto> lottoList, List<Integer> winningNumber, int amount) {
        calculateCount(lottoList, winningNumber);
        calculateIncome();
        return (income / amount) * 100;
    }

    @Override
    public String toString() {
        return totalCount.keySet().stream()
                .map(key -> key + "개 일치" + "(" + winningPrice.get(key) + "원)- " + totalCount.get(key) + "개")
                .collect(Collectors.joining("\n"));
    }
}
