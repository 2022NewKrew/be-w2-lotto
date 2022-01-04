package domain;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIFTH(5, 1_500_500),
    FIFTHWITHBONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int countOfMatch;
    private final int money;

    LottoRank(int countOfMatch, int money) {
        this.countOfMatch = countOfMatch;
        this.money = money;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public static LottoRank find(int matchedNumber) {
        return Arrays.stream(values())
                .filter(matchedNumber -> LottoRank.valueOf(matchedNumber))
    }
}
