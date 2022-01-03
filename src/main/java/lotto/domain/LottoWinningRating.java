package lotto.domain;

public enum LottoWinningRating {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NOTHING(0, 0);

    private final Integer matchCount;
    private final Integer winningMoney;

    LottoWinningRating(Integer matchCount, Integer winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getWinningMoney() {
        return winningMoney;
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


}
