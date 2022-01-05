package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private LottoController() {
    }

    public static void start(InputView inputView, OutputView outputView) {
        int inputPrice = inputView.getInputPrice();
        outputView.printLottoTicketCount(inputPrice);

        Money inputMoney = new Money(inputPrice);
        LottoNumbersGenerator lottoNumbersGenerator = new RandomLottoNumberGenerator();
        LottoTickets lottoTickets = LottoMachine.issue(inputMoney, lottoNumbersGenerator);
        outputView.printLottoTickets(lottoTickets);

        LottoNumbers lottoNumbers = inputView.getWinningNumbers();
        LottoNumber bonusNumber = inputView.getBonusNumber();
        WinningNumbers winningNumbers = WinningNumbers.from(lottoNumbers, bonusNumber);
        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, lottoTickets);
        outputView.printLottoStatistics(inputMoney, lottoStatistics);
    }
}
