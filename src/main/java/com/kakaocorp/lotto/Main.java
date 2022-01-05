package com.kakaocorp.lotto;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.ui.StreamLottoView;
import com.kakaocorp.lotto.ui.LottoView;
import com.kakaocorp.lotto.ui.LottoController;

import java.util.Random;

public class Main {

    public static void main(String... args) {
        Random random = new Random();
        LottoDispenser dispenser = new LottoDispenser(random);
        ProfitCalculator calculator = new ProfitCalculator();
        ResultCounter counter = new ResultCounter();

        LottoView view = new StreamLottoView(System.in, System.out);
        LottoController presenter = new LottoController(view, dispenser, counter, calculator);

        presenter.onStart();
    }
}
