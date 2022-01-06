package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    EMPTY(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return matchBonus ? SECOND : THIRD;
        }
        Rank[] ranks = values();
        List<Rank> returnValue = Arrays.asList(ranks).stream()
                                       .filter(rank->rank.countOfMatch == countOfMatch)
                                       .collect(Collectors.toList());
        if (returnValue.isEmpty()) {
            return EMPTY;
        }
        return returnValue.get(0);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

