package com.upperleaf.domain.lotto;

/**
 * 로또 번호와 당첨번호를 비교한 뒤 결과를 표현하는 객체
 */
class LottoMatchResult {
    private final long matchNum;
    private final boolean matchedBonus;

    LottoMatchResult(long matchNum, boolean matchedBonus) {
        this.matchNum = matchNum;
        this.matchedBonus = matchedBonus;
    }

    public long getMatchNum() {
        return matchNum;
    }
    public boolean isMatchedBonus() {
        return matchedBonus;
    }
}
