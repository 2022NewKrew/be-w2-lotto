package lotto.domain;

import java.util.Arrays;

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
        return Arrays.stream(LottoWinningRating.values())
                .filter(lottoWinningRating -> lottoWinningRating.getMatchCount() == matchCount)
                .findAny()
                .orElse(LottoWinningRating.NOTHING);
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getWinningMoney() {
        return winningMoney;
    }

}
