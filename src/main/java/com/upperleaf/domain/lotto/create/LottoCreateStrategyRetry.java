package com.upperleaf.domain.lotto.create;

import com.upperleaf.domain.lotto.Lotto;

public class LottoCreateStrategyRetry implements LottoCreateStrategy {

    private final LottoCreateStrategy lottoCreateStrategy;

    public LottoCreateStrategyRetry(LottoCreateStrategy lottoCreateStrategy) {
        this.lottoCreateStrategy = lottoCreateStrategy;
    }

    @Override
    public Lotto createLotto() {
        Lotto lotto = null;
        while(lotto == null) {
            lotto = createLottoInternal();
        }
        return lotto;
    }

    private Lotto createLottoInternal() {
        Lotto lotto = null;
        try {
            lotto = lottoCreateStrategy.createLotto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("다시 입력하세요.");
        }
        return lotto;
    }
}
