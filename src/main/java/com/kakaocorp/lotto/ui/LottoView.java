package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

import java.util.List;
import java.util.Map;

public abstract class LottoView {

    protected LottoPresenter presenter;

    public void attachPresenter(LottoPresenter presenter) {
        this.presenter = presenter;
    }

    public abstract void showPaymentPrompt(LottoContext context);
    public abstract void printLottos(List<LottoTicket> tickets);
    public abstract void showWinningNumbersPrompt(LottoContext context);
    public abstract void printResults(List<Map.Entry<LottoResult, Integer>> results, int profit);
}
