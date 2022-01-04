package domain;

import common.model.LottoRank;
import domain.model.WinningLottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoTicket getLottoTicket(int index) {
        return lottoTickets.get(index);
    }

    public int getSize() {
        return lottoTickets.size();
    }

    public Map<LottoRank, Integer> getCountMapByRank(WinningLottoTicket winningTicket) {
        Map<LottoRank, Integer> countMap = new HashMap<>();
        for(LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = lottoTicket.checkRank(winningTicket);
            countMap.put(lottoRank, countMap.getOrDefault(lottoRank, 0) + 1);
        }
        return countMap;
    }

}
