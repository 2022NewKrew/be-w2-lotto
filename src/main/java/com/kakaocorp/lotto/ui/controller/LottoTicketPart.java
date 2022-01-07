package com.kakaocorp.lotto.ui.controller;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.ui.view.LottoTicketPartView;
import com.kakaocorp.lotto.validation.LessThanMinimumException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LottoTicketPart extends LottoControllerPart<LottoTicketPartView> {

    private final LottoDispenser dispenser;

    public LottoTicketPart(LottoTicketPartView view, LottoDispenser dispenser) {
        super(view);
        this.dispenser = dispenser;
    }

    public List<LottoTicket> handle(int payment) {
        int manualCount = getValidValue(this::getManualCount);
        view.showManualTicketPromptHeader();
        List<LottoTicket> manual = showManualTicketsPrompts(manualCount);
        List<LottoTicket> tickets = dispenser.purchase(payment, manual);
        printTickets(tickets);
        return tickets;
    }

    private int getManualCount() {
        int minimum = 1;
        int count = view.showManualCountPrompt();
        if (count < minimum) {
            throw new LessThanMinimumException(minimum);
        }
        return count;
    }

    private List<LottoTicket> showManualTicketsPrompts(int manualCount) {
        List<LottoTicket> manualTickets = new ArrayList<>(manualCount);
        for (int i = 0; i < manualCount; i++) {
            List<Integer> numbers = getValidNumbers(view::acceptManualTicketInput);
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
