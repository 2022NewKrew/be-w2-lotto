package view;

import domain.entity.LottoTicket;
import domain.entity.LottoTickets;
import view.dto.WinningResultResponse;

import java.io.IOException;

public class LottoGameView {

    private static UserInputScreen userInputScreen = new UserInputScreen();

    private static LottoResultScreen lottoResultScreen = new LottoResultScreen();

    public int queryPurchaseAmount() throws IOException {
        return userInputScreen.queryPurchaseAmount();
    }

    public LottoTicket queryWinningLotto() throws IOException {
        return userInputScreen.queryWinningLotto();
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(String.format("%s개를 구매했습니다.", lottoTickets.getSize()));
        lottoTickets.getLottoTickets().forEach(System.out::println);
    }

    public void printLottoResults(WinningResultResponse lottoGameResponse) {
        lottoResultScreen.printLottoResults(lottoGameResponse);
    }
}
