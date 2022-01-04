package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoTicketFactory factory = new LottoTicketFactoryImpl();

    public void start() {
        try {
            int totalAmount = inputView.inputAmountForPurchase();
            List<LottoTicket> tickets = purchaseLotteries(totalAmount);
            outputView.printLotteries(tickets);
            int bonusNumber = inputView.inputBonusNumber();
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            calculateAndPrintResult(tickets, winningNumbers);
        } catch (Exception e) {
            outputView.printErrorMessage(e);
        }
    }

    private List<LottoTicket> purchaseLotteries(int amount) {
        return factory.createRandomLottoTickets(amount / LottoTicket.PRICE);
    }

    private void calculateAndPrintResult(List<LottoTicket> tickets, List<Integer> winningNumbers) {
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumbers);
        Map<LottoRank, Integer> resultCounts = calculator.getLottoResultCounts(tickets);
        int earnRate = calculator.calculateEarningRate(resultCounts, tickets.size() * LottoTicket.PRICE);
        outputView.printResult(resultCounts, earnRate);
    }

}
