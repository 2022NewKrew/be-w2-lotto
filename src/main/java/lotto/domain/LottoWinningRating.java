package lotto.domain;

import java.util.Arrays;

public enum LottoWinningRating {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0);

    private final int matchCount;
    private final int winningMoney;

    LottoWinningRating(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoWinningRating getWinningRating(int matchCount) {
        return Arrays.stream(LottoWinningRating.values())
                .filter(lottoWinningRating -> lottoWinningRating.getMatchCount() == matchCount)
                .findAny()
                .orElse(LottoWinningRating.NOTHING);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
