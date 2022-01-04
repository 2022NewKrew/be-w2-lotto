package com.upperleaf.domain.lotto;

/**
 * matchNumber 이하로 전부 매치시키는 함수 객체
 * 어떤 로또 등수에도 해당하지 않을때 사용
 */
public class NoneRankingMatchFunction implements RankingMatchFunction {
    private final long matchNumber;

    public NoneRankingMatchFunction(long matchNumber) {
        this.matchNumber = matchNumber;
    }

    @Override
    public Boolean apply(LottoMatchResult lottoMatchResult) {
        return lottoMatchResult.getMatchNum() <= matchNumber;
    }

    @Override
    public long getMatchNumber() {
        return matchNumber;
    }
}
