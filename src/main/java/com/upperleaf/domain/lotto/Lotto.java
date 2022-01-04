package com.upperleaf.domain.lotto;

import java.util.List;

class Lotto {

    private final List<Integer> numbers;
    /**
     * 로또 표현 객체
     * @param numbers 로또를 표현하는 숫자 리스트
     */
    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * 로또와 로또 당첨번호를 비교해서 로또 등수 객체 반환
     * @param winningNumber 로또 당첨 번호
     * @return 로또 등수 객체
     */
    public LottoRanking match(LottoWinningNumber winningNumber) {
        long matchNumbers = numbers.stream().filter(winningNumber::containsWinningNumber).count();
        boolean matchBonusNumber = numbers.stream().anyMatch(winningNumber::isEqualToBonusNumber);

        LottoMatchResult result = new LottoMatchResult(matchNumbers, matchBonusNumber);
        return LottoRanking.getLottoRankingByMatchResult(result);
    }

    public String getLottoInfo() {
        return numbers.toString();
    }
}
