package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

public abstract class LottoView {

    protected LottoPresenter presenter;

    public void attachPresenter(LottoPresenter presenter) {
        this.presenter = presenter;
    }

    public abstract void showPaymentPrompt(LottoContext context);
    public abstract void printTicketHeader(int size);
    public abstract void printTicket(LottoTicket tickets);
    public abstract void showWinningNumbersPrompt(LottoContext context);
    public abstract void printResultHeader();
    public abstract void printResult(LottoResult result, int count);
    public abstract void printProfit(int profit);
}
