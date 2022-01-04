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

    public static void main(String[] args) throws IOException {


        LottoMachine lottoMachine = new LottoMachine();

        LottoPrice lottoPrice = inputLottoPrice();
        List<LottoTicket> lottoTickets = lottoMachine.makeLottoTicket(lottoPrice);

        printLottoTickets(lottoTickets);

        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(inputWinningNumber(), inputBonusBall());
        LottoResult lottoResult = new LottoResult(winningLottoTicket, lottoTickets, lottoPrice.getPrice());

        printLottoResult(lottoResult);
    }
}
