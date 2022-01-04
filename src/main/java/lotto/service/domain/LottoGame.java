package lotto.service.domain;

import java.util.List;

public class LottoGame {
    private List<LottoTicket> lottoTickets ;

    public LottoGame(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
