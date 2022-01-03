import domain.LottoMachine;
import domain.LottoPrice;
import domain.LottoResult;
import domain.LottoTicket;
import view.InputView;
import view.OutputView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        LottoPrice lottoPrice = InputView.inputLottoPrice();
        LottoMachine lottoMachine = new LottoMachine();
        List<LottoTicket> lottoTickets = lottoMachine.makeLottoTicket(lottoPrice);

        OutputView.printLottoTickets(lottoTickets, wr);

        LottoTicket winningTicket = InputView.inputWinningNumber();
        LottoResult lottoResult = new LottoResult(winningTicket, lottoTickets, lottoPrice.getPrice());
        OutputView.printLottoResult(lottoResult, wr);
        wr.close();
    }
}
