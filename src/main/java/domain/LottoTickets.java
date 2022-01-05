package domain;

import common.model.LottoRank;
import domain.model.ticket.LottoTicket;
import domain.model.PurchaseInfo;
import domain.model.ticket.WinningLottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
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

    public static LottoTickets createLottoTickets(PurchaseInfo purchaseInfo) {
        Stream<LottoTicket> manualTicketStream = purchaseInfo
                .getManualLottoTickets().stream()
                .map(lottoNumbers -> LottoTicket.from(lottoNumbers));

        Stream<LottoTicket> autoTicketStream = IntStream.range(0, purchaseInfo.getAutoLottoCount())
                .mapToObj(num -> LottoTicket.createAutoLottoTicket());

        return new LottoTickets(Stream.concat(manualTicketStream, autoTicketStream).collect(Collectors.toList()));
    }

}
