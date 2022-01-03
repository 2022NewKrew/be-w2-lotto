import domain.entity.LottoTicket;
import domain.entity.LottoTickets;
import domain.service.LottoGameService;
import view.LottoGameView;
import view.dto.WinningResultResponse;

import java.io.IOException;

public class LottoApp {

    private static LottoGameView lottoGameView = new LottoGameView();

    private static LottoGameService lottoGame = new LottoGameService();

    public static void main(String[] args) {
        try{
            start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void start() throws IOException {
        int amount = lottoGameView.queryPurchaseAmount();
        LottoTickets lottoTickets = lottoGame.purchase(amount);

        lottoGameView.printLottoTickets(lottoTickets);

        LottoTicket winningLotto = lottoGameView.queryWinningLotto();
        WinningResultResponse winningResultResponse = lottoGame.checkWinningLotto(lottoTickets, winningLotto);

        lottoGameView.printLottoResults(winningResultResponse);
    }

}
