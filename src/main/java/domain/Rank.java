package domain;

public enum Rank {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean isMatchBonus;

    Rank(int countOfMatch, int winningMoney, boolean isMatchBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isMatchBonus = isMatchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean isMatchBonus) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return isMatchBonus ? SECOND : THIRD;
            }
            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }
        return null;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
