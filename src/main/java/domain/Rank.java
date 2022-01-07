package domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank{
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true){
        @Override
        public String toString() {
            return String.format("%d개 일치, 보너스볼 일치 (%d원) -", getCountOfMatch(), getWinningMoney());
        }
    },
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean isBonusNumber;

    Rank(int countOfMatch, int winningMoney, boolean isBonusNumber){
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isBonusNumber = isBonusNumber;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private boolean isBonusNumber() {
        return isBonusNumber;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus){
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .filter(rank -> (countOfMatch != SECOND.countOfMatch) || (rank.isBonusNumber() == matchBonus))
                .findFirst()
                .orElse(NONE);

    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원) -", getCountOfMatch(), getWinningMoney());
    }
}
