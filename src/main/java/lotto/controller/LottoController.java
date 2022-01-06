package lotto.controller;

import lotto.domain.*;
import lotto.exception.InvalidInputException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        try {
            List<LottoTicket> tickets = purchaseLottoTickets();
            WinningCondition winningCondition = inputWinningCondition();
            printLottoTicketResults(tickets, winningCondition);
        } catch (Exception e) {
            outputView.printErrorMessage(e);
        }
    }

    private List<LottoTicket> purchaseLottoTickets() throws InvalidInputException {
        int totalNumOfTickets = inputView.inputAmountForPurchase() / LottoTicket.PRICE;
        List<LottoTicket> inputtedTickets = inputLottoTickets(totalNumOfTickets);
        List<LottoTicket> randomTickets = createRandomLottoTickets(totalNumOfTickets - inputtedTickets.size());
        outputView.printLotteries(inputtedTickets, randomTickets);
        return Stream.concat(inputtedTickets.stream(), randomTickets.stream()).collect(Collectors.toList());
    }

    // 구매할 수 있는 로또 티켓의 개수보다 적게 구매하는 것을 확인하기 위해 구매할 수 있는 전체 로또 티켓의 개수를 전달해 준다.
    private List<LottoTicket> inputLottoTickets(int totalNumOfTickets) throws InvalidInputException {
        int numOfInputtedTickets = inputView.inputNumOfLottoTicketsToInput(totalNumOfTickets);
        List<List<Integer>> numbers = inputView.inputNumbersForPurchaseLottoTickets(numOfInputtedTickets);
        return createLottoTickets(numbers);
    }

    private List<LottoTicket> createLottoTickets(List<List<Integer>> numbers) {
        return numbers.stream()
                .map(n -> new LottoTicket(LottoNumbers.createByNumbers(n)))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> createRandomLottoTickets(int sizeOfLottoTickets) {
        return IntStream.range(0, sizeOfLottoTickets)
                .mapToObj(i -> new RandomLottoTicket())
                .collect(Collectors.toList());
    }

    private WinningCondition inputWinningCondition() throws InvalidInputException {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        validateBonusNumber(bonusNumber, winningNumbers);
        return new WinningCondition(LottoNumbers.createByNumbers(winningNumbers), new LottoNumber(bonusNumber));
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) throws InvalidInputException {
        if (winningNumbers.contains(bonusNumber)) {
            throw new InvalidInputException("입력한 보너스 숫자가 당첨 번호에 포함되어 있습니다.");
        }
    }

    private void printLottoTicketResults(List<LottoTicket> tickets, WinningCondition winningCondition) {
        LottoResultCalculator calculator = new LottoResultCalculator(winningCondition);
        Map<LottoRank, Integer> resultCounts = calculator.getLottoResultCounts(tickets);
        long earnRate = calculator.calculateEarningRate(tickets);
        outputView.printResult(resultCounts, earnRate);
    }

}
