package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class TicketPart {

    private final LottoView view;
    private final LottoDispenser dispenser;

    public TicketPart(LottoView view, LottoDispenser dispenser) {
        this.view = view;
        this.dispenser = dispenser;
    }

    public List<LottoTicket> handle(int payment) {
        int manualCount = view.showManualCountPrompt();
        view.showManualTicketPromptHeader();
        List<LottoTicket> manual = showManualTicketsPrompts(manualCount);
        List<LottoTicket> tickets = dispenser.purchase(payment, manual);
        printTickets(tickets);
        return tickets;
    }

    private List<LottoTicket> showManualTicketsPrompts(int manualCount) {
        List<LottoTicket> manualTickets = new ArrayList<>(manualCount);
        for (int i = 0; i < manualCount; i++) {
            List<Integer> numbers = view.acceptManualTicketInput();
            LottoTicket ticket = new LottoTicket(Set.copyOf(numbers));
            manualTickets.add(ticket);
        }
        return manualTickets;
    }

    private void printTickets(Collection<LottoTicket> tickets) {
        view.printTicketHeader(tickets.size());
        for (LottoTicket ticket : tickets) {
            view.printTicket(ticket);
        }
    }
}
