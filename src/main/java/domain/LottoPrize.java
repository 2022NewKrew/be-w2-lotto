package domain;

public enum LottoPrize {
    일등(1, 6, 2000000000, false),
    이등(2, 5, 30000000, true),
    삼등(3, 5, 1500000, false),
    사등(4, 4, 50000, false),
    오등(5, 3, 5000, false),
    꽝(6, 0, 0, false);

    private final static LottoPrize[] lottoPrizeFromRanking = {꽝, 일등, 이등, 삼등, 사등, 오등};
    private final int ranking;
    private final int matchingNum;
    private final int money;
    private final boolean isBonusBallMatch;

    public final static LottoPrize valueOf(int matchingNum, boolean isBonusBallMatch) {
        if (matchingNum == 6) return LottoPrize.일등;
        if (matchingNum == 5 && isBonusBallMatch) return LottoPrize.이등;
        if (matchingNum == 5) return LottoPrize.삼등;
        if (matchingNum == 4) return LottoPrize.사등;
        if (matchingNum == 3) return LottoPrize.오등;
        return LottoPrize.꽝;
    }

    public final static LottoPrize getWithRanking(int ranking) {
        if (ranking > 5) return 꽝;
        return lottoPrizeFromRanking[ranking];
    }

    public final static int getMoneyWithRanking(int ranking) {
        if (ranking > 5) return 0;
        return getWithRanking(ranking).getMoney();
    }
    LottoPrize(int ranking, int matchingNum, int money, boolean isBonusBallMatch) {
        this.ranking = ranking;
        this.matchingNum = matchingNum;
        this.money = money;
        this.isBonusBallMatch = isBonusBallMatch;
    }

    public int getMatchingNum() {
        return matchingNum;
    }

    public int getRanking() {
        return ranking;
    }
    public int getMoney() {
        return money;
    }
}

