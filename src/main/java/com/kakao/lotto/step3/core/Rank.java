package com.kakao.lotto.step3.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() { return countOfMatch; }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        List<Rank> ranks = Arrays.stream(values()).filter(rank -> {
            boolean match = rank.countOfMatch == countOfMatch;
            if (rank == SECOND) {
                return matchBonus && match;
            }
            return match;
        }).collect(Collectors.toList());
        if(ranks.size() == 0)
            return null;
        return ranks.get(0);
    }
}
