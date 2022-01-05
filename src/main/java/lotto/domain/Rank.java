package lotto.domain;

import java.util.Arrays;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 2:30
 */
public enum Rank {
    FIRST(6, Constants.PRINT_FIRST, 2000000000),
    SECOND(5, Constants.PRINT_SECOND, 3000000),
    THIRD(5, Constants.PRINT_THIRD,1500000),
    FOURTH(4, Constants.PRINT_FOURTH, 50000),
    FIFTH(3, Constants.PRINT_FIFTH, 5000);

    private final int countOfMatch;
    private final String matchString;
    private final long winningMoney;

    Rank(int countOfMatch, String matchString, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.matchString = matchString;
        this.winningMoney = winningMoney;
    }

    public String getMatchString() { return matchString; }
    public long getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return validateSecondOrThird(matchBonus);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst().orElse(null);
    }

    private static Rank validateSecondOrThird(boolean matchBonus) {
        return matchBonus ? SECOND : THIRD;
    }
}