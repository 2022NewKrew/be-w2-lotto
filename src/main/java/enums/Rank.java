package enums;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    NOMATCH(0, 0);

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

    public static Rank valueOf(boolean bonusBall, int countOfMatch) {
        if (countOfMatch == SECOND.countOfMatch && bonusBall) {
            return SECOND;
        }
        if (countOfMatch < FIFTH.countOfMatch) {
            return NOMATCH;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

}
