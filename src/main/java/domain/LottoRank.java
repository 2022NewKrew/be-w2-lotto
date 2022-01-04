package domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int countOfMatch;
    private final long winningMoney;

    LottoRank(int countOfMatch, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append(String.format("%d개 일치", countOfMatch));
        if (this == SECOND) {
            description.append(", 보너스 볼 일치");
        }
        description.append(String.format(" (%d원)", winningMoney));
        return description.toString();
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return matchBonus ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(null);
    }
}
