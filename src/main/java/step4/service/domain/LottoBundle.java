package step4.service.domain;

import java.util.List;

public class LottoBundle {
    private List<LottoTicket> ticketBundle;
    private long id;

    public LottoBundle(List<LottoTicket> ticketBundle) {
        this.ticketBundle = ticketBundle;
    }

    public List<LottoTicket> getTicketBundle() {
        return ticketBundle;
    }

    public int getTicketAmount() {
        return ticketBundle.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
