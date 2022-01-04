package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int TICKET_PRICE = 1000;

    private LottoMachine() {
    }

    public static LottoTickets issue(Money inputMoney, LottoNumbersGenerator lottoNumbersGenerator) {
        int numberOfTickets = inputMoney.getPrice() / TICKET_PRICE;
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(LottoTicket.issue(lottoNumbersGenerator));
        }

        return LottoTickets.from(tickets);
    }
}
