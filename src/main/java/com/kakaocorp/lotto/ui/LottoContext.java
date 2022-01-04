package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoTicket;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoContext that = (LottoContext) o;
        return payment == that.payment && Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment, tickets);
    }
}
