package step5.utils;

import java.util.Arrays;

public enum Rank {
    OTHER("other", -1, 0),
    FIFTH("fifth", 3, 5000),
    FOURTH("fourth", 4, 50000),
    THIRD("third", 5, 1500000),
    SECOND("second", 5, 30000000),
    FIRST("first", 6, 2000000000);

    private final String rankStr;
    private final int countOfMatch;
    private final long winningMoney;

    Rank(String rankStr, int countOfMatch, long winningMoney) {
        this.rankStr = rankStr;
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public String getRankStr() { return this.rankStr; }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public long getWinningMoney() {
        return this.winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return matchBonus ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(OTHER);
    }

    public static Rank valueOf(String rankStr, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.rankStr.equals(rankStr))
                .findFirst()
                .orElse(OTHER);
    }

    @Override
    public String toString() {
        return String.format(this != SECOND ? "%d개 일치 (%d원)" : "%d개 일치, 보너스 볼 일치 (%d원)",
                getCountOfMatch(), getWinningMoney());
    }
}
