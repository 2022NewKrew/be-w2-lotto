package com.upperleaf.domain.lotto;

/**
 * 특정 개수와 일치할때 매치하는 함수 객체
 * ex) 1등, 4등, 5등
 */
public class DefaultRankingMatchFunction implements RankingMatchFunction {
    private final long matchNumber;

    public DefaultRankingMatchFunction(long matchNumber) {
        this.matchNumber = matchNumber;
    }

    @Override
    public Boolean apply(LottoMatchResult lottoMatchResult) {
        return matchNumber == lottoMatchResult.getMatchNum();
    }

    @Override
    public long getMatchNumber() {
        return matchNumber;
    }
}
