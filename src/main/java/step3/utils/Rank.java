package step3.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Rank {
    OTHER(-1, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000) {
        @Override
        public String toString() {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)", getCountOfMatch(), getWinningMoney());
        }
    },
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

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(OTHER);
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", getCountOfMatch(), getWinningMoney());
    }
}
