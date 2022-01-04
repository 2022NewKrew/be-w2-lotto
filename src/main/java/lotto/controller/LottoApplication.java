package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void run() {
        int purchaseCount = inputView.inputPurchaseAmount();
        List<LottoTicket> lottoTickets = LottoMachine.createLottoTickets(purchaseCount);
        outputView.printLottoTickets(lottoTickets);

        LottoNumbers winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        outputView.printLottoResult(LottoMachine.getLottoResult(lottoTickets, winningNumbers, bonusNumber), purchaseCount);
    }
}
