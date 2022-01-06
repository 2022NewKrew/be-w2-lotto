package com.upperleaf.domain;

import com.upperleaf.domain.lotto.LottoRanking;
import com.upperleaf.domain.lotto.LottoWinningNumber;
import com.upperleaf.domain.lotto.Lottos;

import java.util.List;

public class LottoMatcher {

    private final Lottos lottos;
    private final LottoWinningNumber winningNumber;

    public LottoMatcher(Lottos lottos, LottoWinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    /**
     * 로또 당첨번호와 로또 번호들을 비교하는 메서드
     * @return 각 로또 번호들의 로또 등수
     */
    public List<LottoRanking> match() {
        return lottos.matchWinningNumber(winningNumber);
    }

    public Long getLottoPrice() {
        return lottos.getLottoPrice();
    }

    public Long getLottosId() {
        return lottos.getId();
    }
}
