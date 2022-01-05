package domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank of(Lotto lotto, Lotto winningNumbers, LottoNumber bonusNum) {
        int countOfMatch = getCountOfMatch(lotto, winningNumbers);
        boolean matchOfBonus = lotto.getNumbers().contains(bonusNum);
        return Rank.valueOf(countOfMatch, matchOfBonus);
    }

    private static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THIRD;
            }

            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }

        return null;
    }

    private static int getCountOfMatch(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }
}
