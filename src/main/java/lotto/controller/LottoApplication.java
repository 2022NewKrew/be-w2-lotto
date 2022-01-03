package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int purchaseCount = inputView.inputPurchaseAmount();
        List<LottoTicket> lottoTickets = LottoMachine.createLottoTickets(purchaseCount);
        outputView.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        outputView.printLottoResult(LottoMachine.getLottoResult(lottoTickets, winningNumbers), purchaseCount);
    }
}
