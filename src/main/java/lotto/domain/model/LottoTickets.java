package lotto.domain.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.game.LottoRank;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public static LottoTickets from(List<Lotto> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void addAllTickets(LottoTickets tickets) {
        lottoTickets.addAll(tickets.lottoTickets);
    }

    public List<LottoRank> toLottoRanks(WinningLotto winningLotto) {
        return lottoTickets.stream()
            .map(lottoTicket -> LottoRank.valueOf(winningLotto, lottoTicket))
            .collect(Collectors.toList());
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
