package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatches;
    private final int winningMoney;

    LottoRank(int countOfMatches, int winningMoney) {
        this.countOfMatches = countOfMatches;
        this.winningMoney = winningMoney;
    }

    public static LottoRank parseResult(int count, boolean isMatchBonusNumber) {
        if (count == SECOND.countOfMatches) {
            return isMatchBonusNumber ? SECOND : THIRD;
        }
        return Arrays.stream(values())
                .filter(lottoResult -> lottoResult.countOfMatches == count)
                .findFirst()
                .orElse(NONE);
    }

    public String toString() {
        return String.format("%d개 일치%s(%d원)", countOfMatches, this.equals(SECOND) ? ", 보너스 볼 일치" : "", winningMoney);
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
