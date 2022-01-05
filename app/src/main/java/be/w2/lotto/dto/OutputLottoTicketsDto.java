package be.w2.lotto.dto;

import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class OutputLottoTicketsDto {
    public final List<List<Integer>> lottoTickets;

    private OutputLottoTicketsDto(List<List<Integer>> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static OutputLottoTicketsDto from(LottoTickets lottoTickets) {
        List<List<Integer>> listedLottoTickets = toListedLottoTickets(lottoTickets);
        return new OutputLottoTicketsDto(listedLottoTickets);
    }

    public int getLottoTicketAmount() {
        return this.lottoTickets.size();
    }

    private static List<List<Integer>> toListedLottoTickets(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets().stream()
                .map(LottoTicket::getLottoNumbers)
                .collect(Collectors.toList());
    }
}
