package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.model.LottoTicket;

import java.util.List;
import java.util.Random;

public class LottoController {

    private final PaymentPart paymentPart;
    private final TicketPart ticketPart;
    private final ProfitPart profitPart;

    public LottoController(LottoView view, Random random) {
        this.paymentPart = new PaymentPart(view);
        LottoDispenser dispenser = new LottoDispenser(random);
        this.ticketPart = new TicketPart(view, dispenser);
        ResultCounter counter = new ResultCounter();
        ProfitCalculator calculator = new ProfitCalculator();
        this.profitPart = new ProfitPart(view, counter, calculator);
    }

    public void onStart() {
        int payment = paymentPart.handle();
        List<LottoTicket> tickets = ticketPart.handle(payment);
        profitPart.handle(payment, tickets);
    }
}
