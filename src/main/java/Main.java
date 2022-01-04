import domain.*;
import view.InputView;
import view.OutputView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import static view.InputView.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        LottoMachine lottoMachine = new LottoMachine();

        LottoPrice lottoPrice = inputLottoPrice();
        List<LottoTicket> lottoTickets = lottoMachine.makeLottoTicket(lottoPrice);

        OutputView.printLottoTickets(lottoTickets, wr);

        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(inputWinningNumber(), inputBonusBall());
        LottoResult lottoResult = new LottoResult(winningLottoTicket, lottoTickets, lottoPrice.getPrice());

        OutputView.printLottoResult(lottoResult, wr);
        wr.close();
    }
}
