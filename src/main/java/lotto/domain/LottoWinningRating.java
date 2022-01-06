package lotto.domain;

import java.util.Arrays;

public enum LottoWinningRating {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NOTHING(0, 0, false);

    private final int matchCount;
    private final int winningMoney;
    private final boolean mustHaveBonusBall;

    LottoWinningRating(int matchCount, int winningMoney, boolean mustHaveBonusBall) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.mustHaveBonusBall = mustHaveBonusBall;
    }

    public static LottoWinningRating getWinningRating(int matchCount, boolean hasBonusBall) {
        return Arrays.stream(LottoWinningRating.values())
                .filter(lottoWinningRating -> lottoWinningRating.matchCount == matchCount)
                .filter(lottoWinningRating -> lottoWinningRating.checkBonusBall(hasBonusBall))
                .findAny()
                .orElse(LottoWinningRating.NOTHING);
    }

    private boolean checkBonusBall(boolean hasBonusBall) {
        if (mustHaveBonusBall) {
            return hasBonusBall;
        }

        return true;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean mustHaveBonusBall() {
        return mustHaveBonusBall;
    }

}
