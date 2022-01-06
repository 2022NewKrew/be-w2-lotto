package model;

public enum LottoRanks {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FORTH(4,50000),
    FIFTH(3,5000),
    NOWINNING(0,0);

    private final int countOfMatch;
    private final int winningMoney;

    LottoRanks(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRanks valueOf(int countOfMatch, boolean matchBonus) {
        LottoRanks[] ranks = values();
        for (LottoRanks rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THIRD;
            }

            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }

        return NOWINNING;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
