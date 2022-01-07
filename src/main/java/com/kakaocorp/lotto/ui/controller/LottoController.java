package com.kakaocorp.lotto.ui.controller;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.ui.view.LottoView;

import java.util.List;
import java.util.Random;

public class LottoController {

    private final LottoPaymentPart paymentPart;
    private final LottoTicketPart ticketPart;
    private final LottoProfitPart profitPart;

    public LottoController(LottoView view, Random random) {
        this.paymentPart = new LottoPaymentPart(view);
        LottoDispenser dispenser = new LottoDispenser(random);
        this.ticketPart = new LottoTicketPart(view, dispenser);
        ResultCounter counter = new ResultCounter();
        ProfitCalculator calculator = new ProfitCalculator();
        this.profitPart = new LottoProfitPart(view, counter, calculator);
    }

    public void onStart() {
        int payment = paymentPart.handle();
        List<LottoTicket> tickets = ticketPart.handle(payment);
        profitPart.handle(payment, tickets);
    }
}
