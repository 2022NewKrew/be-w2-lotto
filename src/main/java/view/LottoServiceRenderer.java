package view;

import domain.LottoPrize;
import domain.LottoTicket;

import java.util.List;
import java.util.Map;

public interface LottoServiceRenderer {
    void displaySentence(String sentence);
    void displayPurchaseStatus(List<LottoTicket> lottoTickets);
    void displayResults(Map<LottoPrize, Long> winningTickets, double rateOfReturn);
}
