package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoApplication {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void run() {
        int purchaseCount = inputView.inputPurchaseAmount();
        int manualPurchaseCount = inputView.inputManualPurchaseCount(purchaseCount);
        int autoPurchaseCount = purchaseCount - manualPurchaseCount;
        List<LottoTicket> manualLottoTicket = LottoMachine.createManualLottoTickets(inputView.inputManualLottoNumbers(manualPurchaseCount));
        List<LottoTicket> autoLottoTickets = LottoMachine.createAutoLottoTickets(autoPurchaseCount);
        List<LottoTicket> totalLottoTickets = Stream.concat(manualLottoTicket.stream(), autoLottoTickets.stream()).collect(Collectors.toList());

        outputView.printLottoTickets(totalLottoTickets, manualPurchaseCount, autoPurchaseCount);

        LottoNumbers winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        outputView.printLottoResult(LottoMachine.getLottoResult(totalLottoTickets, winningNumbers, bonusNumber), purchaseCount);
    }
}
