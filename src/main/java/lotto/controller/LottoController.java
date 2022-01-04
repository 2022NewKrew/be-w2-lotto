package lotto.controller;

import lotto.domain.*;
import lotto.exception.InvalidInputFormatException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoTicketFactory factory = new LottoTicketFactoryImpl();

    public void start() {
        try {
            List<LottoTicket> tickets = purchaseLottoTickets();
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();
            validateBonusNumber(bonusNumber, winningNumbers);
            calculateAndPrintResult(tickets, winningNumbers, bonusNumber);
        } catch (Exception e) {
            outputView.printErrorMessage(e);
        }
    }

    private List<LottoTicket> purchaseLottoTickets() throws InvalidInputFormatException {
        int amount = inputView.inputAmountForPurchase();
        int totalNumOfTickets = amount / LottoTicket.PRICE;
        int numOfInputtedTickets = inputView.inputNumOfLottoTicketsToInput(totalNumOfTickets);
        List<List<Integer>> numbers = inputView.inputNumbersForPurchaseLottoTickets(numOfInputtedTickets);
        List<LottoTicket> inputtedTickets = factory.createLottoTickets(numbers);
        List<LottoTicket> randomTickets = factory.createRandomLottoTickets(totalNumOfTickets - numOfInputtedTickets);
        outputView.printLotteries(inputtedTickets, randomTickets);
        return Stream.concat(inputtedTickets.stream(), randomTickets.stream()).collect(Collectors.toList());
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) throws Exception {
        if (winningNumbers.contains(bonusNumber)) {
            throw new Exception("입력한 보너스 숫자가 당첨 번호에 포함되어 있습니다.");
        }
    }

    private void calculateAndPrintResult(List<LottoTicket> tickets, List<Integer> winningNumbers, int bonusNumber) {
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumbers, bonusNumber);
        Map<LottoRank, Integer> resultCounts = calculator.getLottoResultCounts(tickets);
        int earnRate = calculator.calculateEarningRate(resultCounts, tickets.size() * LottoTicket.PRICE);
        outputView.printResult(resultCounts, earnRate);
    }

}
