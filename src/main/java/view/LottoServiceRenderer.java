package view;

import domain.LottoTicket;

import java.util.Map;

public interface LottoServiceRenderer {
    void displaySentence(String sentence);
    void displayLotto(LottoTicket lotto);
    void displayResults(Map<Long,Long> winningTickets, int purchaseAmount);
}
