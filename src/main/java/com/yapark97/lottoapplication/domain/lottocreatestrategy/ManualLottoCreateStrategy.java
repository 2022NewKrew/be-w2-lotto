package com.yapark97.lottoapplication.domain.lottocreatestrategy;

import com.yapark97.lottoapplication.domain.lotto.Lotto;
import com.yapark97.lottoapplication.view.LottoInput;

import java.util.List;

public class ManualLottoCreateStrategy implements LottoCreateStrategy{
    private final LottoInput lottoInput;

    public ManualLottoCreateStrategy(LottoInput lottoInput) {
        this.lottoInput = lottoInput;
    }

    @Override
    public Lotto create() {
        List<Integer> numbers = lottoInput.takeLottoNumbersInput();
        return new Lotto(numbers);
    }
}
