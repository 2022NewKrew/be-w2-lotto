package com.upperleaf.domain.lotto;

import java.util.function.Function;

/**
 * 로또 결과 객체에 대해서 로또 등수를 판단하기 위한 함수 객체
 * @see  NoneRankingMatchFunction
 * @see DefaultRankingMatchFunction
 * @see RankingBonusMatchFunction
 */
public interface RankingMatchFunction extends Function<LottoMatchResult, Boolean> {
    long getMatchNumber();
}
