package ui.view;

import business.domain.LotteryTicket;
import business.domain.Statistics;

public interface OutputView {

    void printLotteryTickets(LotteryTicket manualBoughtLotteryTicket,
        LotteryTicket randomlyBoughtLotteryTicket);

    void printStatistics(Statistics statistics);
}
