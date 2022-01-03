package view.output;

import domain.Lotto;
import dto.LottoData;

public interface OutputInterface {
    void printTickets(Lotto lotto);
    void printResults(Lotto lotto);
    void printRevenueRate(LottoData lottoData);
}
