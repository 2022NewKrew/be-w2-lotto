package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Money inputMoney = new Money(inputView.getInputPrice());
        LottoTicketCount totalTicketCount = new LottoTicketCount(inputMoney.getNumberOfTickets(LottoMachine.TICKET_PRICE));
        LottoTicketCount manualTicketCount = new LottoTicketCount(inputView.getManualTicketCount());
        LottoTicketCount autoTicketCount = totalTicketCount.sub(manualTicketCount);

        List<String[]> manualLottoNumbers = inputView.getManualLottoNumbers(manualTicketCount.getCount());
        LottoTickets lottoTickets = LottoMachine.issue(autoTicketCount, manualTicketCount, manualLottoNumbers);

        outputView.printLottoTicketCount(manualTicketCount, autoTicketCount);
        outputView.printLottoTickets(lottoTickets);

        WinningNumbers winningNumbers = createWinningNumbers();
        LottoStatistics lottoStatistics = LottoStatistics.of(winningNumbers, lottoTickets, inputMoney);
        outputView.printLottoStatistics(inputMoney, lottoStatistics);
    }

    private WinningNumbers createWinningNumbers() {
        String[] inputWinningNumbers = inputView.getWinningNumbers();
        LottoNumbers lottoNumbers = new ManualLottoNumberGenerator().generateLottoNumbers(inputWinningNumbers);
        LottoNumber bonusNumber = LottoNumber.from(inputView.getBonusNumber());

        return WinningNumbers.from(lottoNumbers, bonusNumber);
    }
}
