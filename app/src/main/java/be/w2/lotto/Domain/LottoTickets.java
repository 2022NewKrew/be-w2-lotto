package be.w2.lotto.Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LottoTickets implements Iterable<LottoTicket> {

    List<LottoTicket> lottoTickets;

    public LottoTickets(int amount, LottoMaker lottoMaker) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoTickets.add(lottoMaker.makeLottoTicket());
        }
    }

    public LottoTickets(List<LottoTicket> lottoTickets){
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public String toString() {
        return lottoTickets.toString();
    }

    @Override
    public Iterator<LottoTicket> iterator() {
        return lottoTickets.iterator();
    }
}
