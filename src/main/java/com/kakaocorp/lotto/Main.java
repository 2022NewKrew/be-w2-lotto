package com.kakaocorp.lotto;

import com.kakaocorp.lotto.ui.controller.LottoController;
import com.kakaocorp.lotto.ui.view.LottoView;
import com.kakaocorp.lotto.ui.view.StreamLottoView;

import java.util.Random;

public class Main {

    public static void main(String... args) {
        Random random = new Random();

        LottoView view = new StreamLottoView(System.in, System.out);
        LottoController presenter = new LottoController(view, random);

        presenter.onStart();
    }
}
