package com.chanminkim.w2.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class WinningStatistics {
    private final EnumMap<WinningState, Integer> countMap;
    private final int payment;

    public WinningStatistics(List<Lotto> lottoList, Lotto winningLotto) {
        this.payment = lottoList.size() * Lotto.LOTTO_PRICE;
        this.countMap = initializeCountMap();
        buildCountMap(lottoList, winningLotto);
    }

    public double calculateEarningPercentage() {
        int lotteryWinnings = calculateLotteryWinnings();
        return (lotteryWinnings - this.payment) / (double) this.payment * 100;
    }

    private int calculateLotteryWinnings() {
        return countMap.entrySet().stream()
                .map(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .reduce(0, Integer::sum);
    }

    private void buildCountMap(List<Lotto> lottoList, Lotto winningLotto) {
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.countMatchedNumbers(winningLotto);
            increaseWinningStateCount(matchedCount);
        }
    }

    private void increaseWinningStateCount(int matchedCount) {
        WinningState winningState = WinningState.findByMatchedCount(matchedCount);
        if (winningState == null) {
            return;
        }
        this.countMap.merge(winningState, 1, Integer::sum);
    }

    private EnumMap<WinningState, Integer> initializeCountMap() {
        EnumMap<WinningState, Integer> countMap = new EnumMap<>(WinningState.class);
        Arrays.stream(WinningState.values())
                .forEach(state -> countMap.put(state, 0));
        return countMap;
    }

    public EnumMap<WinningState, Integer> getCountMap() {
        return countMap;
    }
}
