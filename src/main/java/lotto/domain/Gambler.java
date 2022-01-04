package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gambler {
    private final List<LottoTicket> tickets = new ArrayList<>();

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void addLottoTicket(LottoTicket lottoTicket) {
        tickets.add(lottoTicket);
    }
}
