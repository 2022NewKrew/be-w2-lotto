package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        int inputPrice = inputView.getInputPrice();
        outputView.printLottoTicketCount(inputPrice);

        Money inputMoney = new Money(inputPrice);
        LottoNumbersGenerator lottoNumbersGenerator = new RandomLottoNumberGenerator();
        LottoTickets lottoTickets = LottoMachine.issue(inputMoney, lottoNumbersGenerator);
        outputView.printLottoTickets(lottoTickets);

        WinningNumbers winningNumbers = WinningNumbers.from(inputView.getWinningNumbers());
        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, lottoTickets);
        outputView.printLottoStatistics(inputMoney, lottoStatistics);
    }
}
