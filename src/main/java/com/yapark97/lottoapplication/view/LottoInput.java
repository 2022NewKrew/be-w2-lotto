package com.yapark97.lottoapplication.view;

import java.util.List;

public interface LottoInput {
    int takeLottoPriceInput();

    List<Integer> takeLottoNumbersInput();

    List<Integer> takeWinningNumbersInput();

    int takeBonusBallInput();

    int takeManualLottoNumInput(int lottoNum);
}
