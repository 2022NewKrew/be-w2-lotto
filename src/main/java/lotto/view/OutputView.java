package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicketCount;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

public interface OutputView {
    void printLottoTicketCount(LottoTicketCount ticketCount);
    void printLottoTickets(LottoTickets lottoTickets);
    void printLottoStatistics(Money inputMoney, LottoStatistics lottoStatistics);
}
