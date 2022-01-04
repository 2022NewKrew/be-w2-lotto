package com.upperleaf.view;

import com.upperleaf.domain.LottoRanking;
import com.upperleaf.domain.LottoWinningNumber;
import com.upperleaf.domain.Lottos;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResults {

    private final LottoWinningNumber winningNumber;
    private final Lottos lottos;

    public LottoResults(LottoWinningNumber winningNumber, Lottos lottos) {
        this.winningNumber = winningNumber;
        this.lottos = lottos;
    }

    /**
     * 로또 등수에 따른 개수를 계산하는 함수
     * @return Map(로또 등수, 개수) 객체
     */
    public Map<LottoRanking, Long> getLottoRankingGroup() {
        return matchLottoRanking().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * 로또 등수를 게산하는 함수
     * @return 로또 등수 리스트
     */
    public List<LottoRanking> matchLottoRanking() {
        return winningNumber.match(lottos);
    }
}
