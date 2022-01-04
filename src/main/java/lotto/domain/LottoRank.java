package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private final int countOfMatches;
    private final int winningMoney;

    LottoRank(int countOfMatches, int winningMoney) {
        this.countOfMatches = countOfMatches;
        this.winningMoney = winningMoney;
    }

    public static LottoRank parseResult(int count) {
        return Arrays.stream(values())
                .filter(lottoResult -> lottoResult.countOfMatches == count)
                .findFirst()
                .orElse(null);
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatches() {
        return countOfMatches;
    }
}
