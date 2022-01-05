package com.upperleaf.domain.lotto.create;

import com.upperleaf.domain.lotto.Lotto;

import java.util.List;

public class WebLottoCreateStrategy implements LottoCreateStrategy {

    private final List<List<Integer>> lottoNums;
    private final LottoCreateStrategy randomLottoStrategy = new RandomLottoStrategy();

    private int manualCount = 0;

    public WebLottoCreateStrategy(List<List<Integer>> lottoNums) {
        this.lottoNums = lottoNums;
    }

    @Override
    public Lotto createLotto() {
        if(manualCount < lottoNums.size()) {
            Lotto lotto = new Lotto(lottoNums.get(manualCount));
            manualCount++;
            return lotto;
        }
        return randomLottoStrategy.createLotto();
    }
}
