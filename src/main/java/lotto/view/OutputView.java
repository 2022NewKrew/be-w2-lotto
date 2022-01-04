package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

public interface OutputView {
    void printLottoTicketCount(int inputPrice);
    void printLottoTickets(LottoTickets lottoTickets);
    void printLottoStatistics(Money inputMoney, LottoStatistics lottoStatistics);
}
