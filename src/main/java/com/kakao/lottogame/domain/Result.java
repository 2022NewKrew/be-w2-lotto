package com.kakao.lottogame.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
        board.put(rank, board.get(rank) + 1);
    }

    public Map<Rank, Integer> getBoard() {
        return board;
    }

    public long calculateProfit(Money money) {
        long total = 0L;
        for (Entry<Rank, Integer> entry : board.entrySet()) {
            total += (long) entry.getKey().getReward().getValue() * board.get(entry.getKey());
        }
        return total * 100L / money.getValue();
    }
}
