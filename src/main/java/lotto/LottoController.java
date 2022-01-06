package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private static Money inputMoney;
    private static LottoTicketCount ticketCount;

    private LottoController() {
    }

    public static void start(InputView inputView, OutputView outputView) {
        calculateTicketCount(inputView);

        List<String[]> manualLottoNumbers = inputView.getManualLottoNumbers(ticketCount.getManualTicketCount());
        LottoTickets lottoTickets = LottoMachine.issue(ticketCount, manualLottoNumbers);

        outputView.printLottoTicketCount(ticketCount);
        outputView.printLottoTickets(lottoTickets);

        WinningNumbers winningNumbers = createWinningNumbers(inputView);
        LottoStatistics lottoStatistics = LottoStatistics.of(winningNumbers, lottoTickets, inputMoney);
        outputView.printLottoStatistics(inputMoney, lottoStatistics);
    }

    private static void calculateTicketCount(InputView inputView) {
        inputMoney = new Money(inputView.getInputPrice());
        int totalTicketCount = inputMoney.getNumberOfTickets(LottoMachine.TICKET_PRICE);
        int manualTicketCount = inputView.getManualTicketCount();
        ticketCount = new LottoTicketCount(totalTicketCount, manualTicketCount);
    }

    private static WinningNumbers createWinningNumbers(InputView inputView) {
        String[] inputWinningNumbers = inputView.getWinningNumbers();
        LottoNumbers lottoNumbers = new ManualLottoNumberGenerator().generateLottoNumbers(inputWinningNumbers);
        LottoNumber bonusNumber = LottoNumber.from(inputView.getBonusNumber());

        return WinningNumbers.from(lottoNumbers, bonusNumber);
    }
}
