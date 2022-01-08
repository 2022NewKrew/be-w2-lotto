package com.kakao.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Result {

    private final Map<Rank, Integer> result = new HashMap<>();
    private int profitRatio = 0;
    private List<String> message = new ArrayList<>();

    public Result(int money, List<Lotto> lottos, WinningLotto winningLotto) {
        setResult(lottos, winningLotto);
        if (money != 0) { setProfitRatio(money); }
        setMessage();
    }

    public Map<Rank, Integer> getResult() { return result; }

    public int getProfitRatio() { return profitRatio; }

    public List<String> getMessage() { return message; }

    private void setResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            countRank(lotto, winningLotto);
        }
    }

    private void countRank(Lotto lotto, WinningLotto winningLotto) {
        Rank rank = winningLotto.checkRank(lotto);
        if (rank != null) {
            result.put(rank, result.get(rank) + 1);
        }
    }

    private void setProfitRatio(int money) {
        int profit = result.keySet().stream()
                .mapToInt(this::calcWinningMoney)
                .sum();
        profitRatio = (profit - money) / money * 100;
    }

    private int calcWinningMoney(Rank rank) {
        int count = result.get(rank);
        return rank.getWinningMoney() * count;
    }

    private void setMessage() {
        message = result.keySet().stream()
                .sorted(Comparator.comparing(Rank::getExplanation))
                .map(this::mapToString)
                .collect(Collectors.toList());
    }

    private String mapToString(Rank rank) {
        int count = result.get(rank);
        return String.format("%s (%d원) - %d개\n", rank.getExplanation(), rank.getWinningMoney(), count);
    }

    public static int getCutomLottoCount(List<Lotto> lottos) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.getType().equals(LottoType.CUSTOM))
                .count();
    }
}
