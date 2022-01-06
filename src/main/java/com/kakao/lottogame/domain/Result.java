package com.kakao.lottogame.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Result {

    private final EnumMap<Rank, Integer> board;

    private Result() {
        board = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            board.put(rank, 0);
        }
    }

    public static Result from(List<Rank> ranks) {
        Result result = new Result();
        ranks.forEach(result::add);
        return result;
    }

    private void add(Rank rank) {
        board.computeIfPresent(rank, (k, v) -> v + 1);
    }

    public List<Entry<Rank, Integer>> getBoardWithout(Rank... ranks) {
        return board.entrySet()
            .stream()
            .filter(entry -> Arrays.stream(ranks).noneMatch(rank -> rank.equals(entry.getKey())))
            .collect(Collectors.toList());
    }

    public int getCountOf(Rank rank) {
        return board.get(rank);
    }

    public long calculateProfitRate(Money money) {
        return (calculateProfit() - money.getValue()) * 100 / money.getPrincipal();
    }

    private long calculateProfit() {
        long total = 0L;
        for (Entry<Rank, Integer> entry : board.entrySet()) {
            Rank rank = entry.getKey();
            long count = entry.getValue();
            total += rank.getRewardValue() * count;
        }
        return total;
    }
}
