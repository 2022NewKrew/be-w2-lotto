package com.upperleaf.domain.lotto;

import java.util.Arrays;

public enum LottoRanking {
    NONE(0, new NoneRankingMatchFunction(2)),
    FIFTH(5000, new DefaultRankingMatchFunction(3)),
    FOURTH(50000, new DefaultRankingMatchFunction(4)),
    THIRD(1500000, new RankingBonusMatchFunction(5, false)),
    TWO(30000000, new RankingBonusMatchFunction(5, true)),
    FIRST(2000000000, new DefaultRankingMatchFunction(6));

    private final RankingMatchFunction rankingMatchFunction;
    private final long winningPrice;

    /**
     * 로또 등수를 표현하기 위한 객체
     * @param winningPrice 해당 등수의 당첨 금액
     * @param rankingMatchFunction 해당 등수를 달성하기 위해 일치해야하는 로또 번호 개수 및 보너스를 체크하는 함수 객체
     */
    LottoRanking(long winningPrice, RankingMatchFunction rankingMatchFunction) {
        this.winningPrice = winningPrice;
        this.rankingMatchFunction = rankingMatchFunction;
    }

    /**
     * 로또 매치 결과 객체를 이용해서 로또 등수를 판단 후 해당하는 로또 등수 반환
     * 판단 기준은 RakingMatchFunction 객체 호출 결과 True 일 때
     * @see RankingMatchFunction
     * @param matchResult 로또와 당첨번호를 비교한 결과를 표현하는 객체
     * @return 로또 등수
     */
    public static LottoRanking getLottoRankingByMatchResult(LottoMatchResult matchResult) {
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking.isMatchable(matchResult))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatchable(LottoMatchResult matchResult) {
        return rankingMatchFunction.apply(matchResult);
    }

    public long getWinningPrice() {
        return winningPrice;
    }

    public long getMatchNumber() {
        return rankingMatchFunction.getMatchNumber();
    }

    public boolean isMatchedBonus() {
        if (!(rankingMatchFunction instanceof RankingBonusMatchFunction)) {
            return false;
        }
        return ((RankingBonusMatchFunction)rankingMatchFunction).isMatchBonus();
    }
}
