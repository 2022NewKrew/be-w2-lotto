import lotto.controller.LottoController;
import lotto.domain.component.LottoPrice;
import lotto.domain.component.LottoTicket;
import lotto.domain.component.WinningLottoTicket;
import lotto.domain.LottoMachine;
import lotto.domain.result.LottoResult;

import java.io.IOException;
import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class Main {

    private static final LottoController lottoController = new LottoController();
    public static void main(String[] args) throws IOException {

        LottoPrice lottoPrice = inputLottoPrice();
        List<LottoTicket> lottoTickets = lottoController.purchaseLotto(lottoPrice);
        printLottoTickets(lottoTickets);

        WinningLottoTicket winningLottoTicket = lottoController.issueWinningLotto(inputWinningNumber(), inputBonusBall());
        LottoResult lottoResult = lottoController.getLottoResult(winningLottoTicket, lottoTickets, lottoPrice.getPrice());
        printLottoResult(lottoResult);
    }
}
