package lotto.controller;

import lotto.domain.*;
import lotto.exception.InvalidInputFormatException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int MAX_TRIAL_COUNT = 3;
    private static final int PRICE_OF_LOTTERY = 1000;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoTicketFactory factory = new LottoTicketFactoryImpl();

    public void start() {
        try {
            int totalAmount = inputAmountOfPurchase();
            List<LottoTicket> tickets = purchaseLotteries(totalAmount);
            printLotteries(tickets);
            List<Integer> winningNumbers = inputWinningNumbers();
            calculateAndPrintResult(tickets, winningNumbers);
        } catch (Exception e) {
            outputView.printErrorMessage(e);
        }
    }

    private int inputAmountOfPurchase() {
        return inputAmountOfPurchase(0);
    }

    private int inputAmountOfPurchase(int trialCount) {
        if (trialCount >= MAX_TRIAL_COUNT) {
            throw new RuntimeException(MAX_TRIAL_COUNT + "회 이상 잘못 입력하여 게임을 종료합니다.");
        }

        try {
            return inputView.inputAmountForPurchase();
        } catch (InvalidInputFormatException e) {
            outputView.printErrorMessage(e);
            return inputAmountOfPurchase(trialCount + 1);
        }
    }

    private List<LottoTicket> purchaseLotteries(int amount) {
        int numOfTickets = amount / PRICE_OF_LOTTERY;
        if (numOfTickets == 0) {
            throw new RuntimeException("로또를 구매할 수 없습니다.");
        }

        return factory.createRandomLottoTickets(numOfTickets);
    }

    private void printLotteries(List<LottoTicket> lotteries) {
        outputView.printLotteries(lotteries);
    }
    
    private List<Integer> inputWinningNumbers() throws InvalidInputFormatException {
        return inputView.inputWinningNumbers();
    }

    private void calculateAndPrintResult(List<LottoTicket> tickets, List<Integer> winningNumbers) {
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumbers);
        Map<LottoRank, Integer> resultCounts = calculator.getLottoResultCounts(tickets);
        int earnRate = calculator.calculateEarningRate(resultCounts, tickets.size() * PRICE_OF_LOTTERY);
        outputView.printResult(resultCounts, earnRate);
    }

}
