package com.upperleaf.domain.lotto;

/**
 * 특정 개수와 보너스 볼까지 일치해야하는지 매치해야할때 사용하는 함수 객체
 * ex) 2등, 3등
 */
public class RankingBonusMatchFunction implements RankingMatchFunction {
    private final long matchNumber;
    private final boolean isMatchBonus;

    public RankingBonusMatchFunction(long matchNum, boolean isMatchBonus) {
        this.matchNumber = matchNum;
        this.isMatchBonus = isMatchBonus;
    }

    @Override
    public Boolean apply(LottoMatchResult lottoMatchResult) {
        return lottoMatchResult.getMatchNum() == matchNumber && isMatchBonus == lottoMatchResult.isMatchedBonus();
    }

    @Override
    public long getMatchNumber() {
        return matchNumber;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }
}
