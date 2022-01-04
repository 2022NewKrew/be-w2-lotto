package be.w2.lotto.dto;

import be.w2.lotto.domain.LottoTickets;
import be.w2.lotto.domain.LottoNumber;
import be.w2.lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsDto {
    public final List<List<Integer>> lottoTickets;

    private LottoTicketsDto(List<List<Integer>> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTicketsDto from(LottoTickets lottoTickets) {
        List<List<Integer>> listedLottoTickets = toListedLottoTickets(lottoTickets);
        return new LottoTicketsDto(listedLottoTickets);
    }

    public int getLottoTicketAmount() {
        return this.lottoTickets.size();
    }

    private static List<List<Integer>> toListedLottoTickets(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets()
                .stream().map(LottoTicket::getLottoNumbers).collect(Collectors.toList())
                .stream().map(LottoTicketsDto::toLottoNumber).collect(Collectors.toList())
                ;
    }

    private static List<Integer> toLottoNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }
}
