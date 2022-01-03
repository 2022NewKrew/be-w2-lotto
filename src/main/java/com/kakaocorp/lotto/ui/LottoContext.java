package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoTicket;

import java.util.List;

public class LottoContext {

    private int payment;
    private List<LottoTicket> tickets;

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }
}
