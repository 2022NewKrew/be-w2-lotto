package step2.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Rank {
    OTHER(-1, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int countOfMatch;
    private final long winningMoney;

    Rank(int countOfMatch, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
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
