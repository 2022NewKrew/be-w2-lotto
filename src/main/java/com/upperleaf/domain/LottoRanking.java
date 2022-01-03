package com.upperleaf.domain;

import java.util.Arrays;

public enum LottoRanking {
    FOURTH(5000, 3),
    THIRD(50000, 4),
    SECOND(1500000, 5),
    FIRST(2000000000, 6),
    NONE(0, 0);

    private final long winningPrice;
    private final long matchNumber;

    /**
     * 로또 등수를 표현하기 위한 객체
     * @param winningPrice 해당 등수의 당첨 금액
     * @param matchNumber 해당 등수를 달성하기 위해 일치해야하는 로또 번호 개수
     */
    LottoRanking(long winningPrice, long matchNumber) {
        this.winningPrice = winningPrice;
        this.matchNumber = matchNumber;
    }

    public static LottoRanking getLottoRankingByMatchNumber(long matchNumber) {
        return Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking.match(matchNumber))
                .findFirst()
                .orElse(NONE);
    }

    public boolean match(long matchNumber) {
        return this.matchNumber == matchNumber;
    }

    public long getMatchNumber() {
        return matchNumber;
    }

    public long getWinningPrice() {
        return winningPrice;
    }
}
