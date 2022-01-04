package lotto.domain;

public enum LottoWinningRating {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0);

    private final Integer matchCount;
    private final Integer winningMoney;

    LottoWinningRating(Integer matchCount, Integer winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoWinningRating getWinningRating(Integer matchCount) {
        if (matchCount.equals(FIRST.matchCount)) {
            return FIRST;
        }

        if (matchCount.equals(SECOND.matchCount)) {
            return SECOND;
        }

        if (matchCount.equals(THIRD.matchCount)) {
            return THIRD;
        }

        if (matchCount.equals(FOURTH.matchCount)) {
            return FOURTH;
        }

        return NOTHING;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getWinningMoney() {
        return winningMoney;
    }

}
