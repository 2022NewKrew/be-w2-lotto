package step1.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    OTHER(-1, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return matchBonus ? SECOND : THIRD;
        }

        if (Arrays.stream(values()).anyMatch(rank -> rank.countOfMatch == countOfMatch)) {
            return Arrays.stream(values()).filter(rank -> rank.countOfMatch == countOfMatch)
                    .collect(Collectors.toList()).get(0);
        }

        return OTHER;
    }
}
