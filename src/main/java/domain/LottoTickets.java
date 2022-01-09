package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> manualTicket;
    private final List<LottoTicket> randomTicket;

    public LottoTickets(List<LottoTicket> manualTicket, List<LottoTicket> randomTicket) {
        if (manualTicket == null || randomTicket == null) {
            throw new IllegalArgumentException();
        }

        this.manualTicket = Collections.unmodifiableList(manualTicket);
        this.randomTicket = Collections.unmodifiableList(randomTicket);
    }

    public List<LottoTicket> totalTickets() {
        List<LottoTicket> totalTickets = new ArrayList<>();

        totalTickets.addAll(manualTicket);
        totalTickets.addAll(randomTicket);
        return totalTickets;
    }
}
