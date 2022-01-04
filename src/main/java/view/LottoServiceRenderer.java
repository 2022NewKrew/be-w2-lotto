package view;

import domain.LottoPrize;
import domain.LottoTicket;

import java.util.Map;

public interface LottoServiceRenderer {
    void displaySentence(String sentence);
    void displayLotto(LottoTicket lotto);
    void displayResults(Map<LottoPrize, Long> winningTickets, double rateOfReturn);
}
