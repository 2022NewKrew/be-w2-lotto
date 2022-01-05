package lotto.domain;

import java.util.List;

public interface LottoTicketFactory {
    LottoTicket createRandomLottoTicket();
    List<LottoTicket> createRandomLottoTickets(int numOfTickets);
    LottoTicket createLottoTicket(List<Integer> numbers);
    List<LottoTicket> createLottoTickets(List<List<Integer>> numbers);
}
