package com.upperleaf.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumber {

    private final List<Integer> winningNumbers;

    public LottoWinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    /**
     * 로또 당첨번호와 로또 번호들을 비교하는 메서드
     * @param lottos 비교할 로또 번호들을 표현하는 객체
     * @return 각 로또 번호들의 로또 등수
     */
    public List<LottoRanking> match(Lottos lottos) {
        List<Long> matchNumbers = lottos.matchWinningNumber(winningNumbers);
        return matchNumbers.stream().map(LottoRanking::getLottoRankingByMatchNumber).collect(Collectors.toList());
    }
}
