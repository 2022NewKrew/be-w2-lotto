package step3.output;

import step3.lotto.domain.LottoTicket;

import java.util.List;
import java.util.Map;

public interface OutputView {
    public void printResult(Map<Integer, Integer> results, double profitRate);
    public void printTickets(List<LottoTicket> lottoTickets);
}
