package com.upperleaf.domain.lotto.create;

import com.upperleaf.domain.lotto.Lotto;

import java.util.List;

public class ManualLottoStrategy implements LottoCreateStrategy {

    private final List<List<Integer>> lottoNums;
    private int manualCount = 0;

    public ManualLottoStrategy(List<List<Integer>> lottoNums) {
        this.lottoNums = lottoNums;
    }

    @Override
    public Lotto createLotto() {
        Lotto lotto = new Lotto(lottoNums.get(manualCount));
        manualCount++;
        return lotto;
    }
}
