package view;

import domain.LottoTicket;
import domain.WinningStatus;

import java.util.List;

public interface LottoServiceRenderer {
    void displaySentence(String sentence);
    void displayPurchaseStatus(List<LottoTicket> lottoTickets, int numberOfManualLottoTickets, int numberOfAutoLottoTickets);
    void displayResults(WinningStatus winningTickets, double rateOfReturn);
}
