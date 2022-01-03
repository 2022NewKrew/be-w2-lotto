package com.kakaocorp.lotto;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.model.Rule;
import com.kakaocorp.lotto.ui.StreamLottoView;
import com.kakaocorp.lotto.ui.LottoView;
import com.kakaocorp.lotto.ui.LottoPresenter;

import java.util.Random;

public class Main {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MAX_COUNT = 6;

    public static void main(String... args) {
        Random random = new Random();
        Rule rule = new Rule.Builder()
                .random(random)
                .minNumber(LOTTO_MIN_NUMBER)
                .maxNumber(LOTTO_MAX_NUMBER)
                .numberCount(LOTTO_MAX_COUNT)
                .price(LOTTO_PRICE)
                .build();
        LottoDispenser dispenser = new LottoDispenser(rule);
        ProfitCalculator calculator = new ProfitCalculator();
        ResultCounter counter = new ResultCounter();

        LottoView view = new StreamLottoView(System.in, System.out);
        LottoPresenter presenter = new LottoPresenter(view, dispenser, counter, calculator);

        presenter.onStart();
    }
}
