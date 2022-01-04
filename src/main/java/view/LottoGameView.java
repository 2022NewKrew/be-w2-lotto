package view;

import domain.LottoTickets;
import view.dto.WinningResultResponse;
import view.screen.LottoResultScreen;
import view.screen.UserInputScreen;

import java.io.IOException;
import java.util.List;

public class LottoGameView {

    private static UserInputScreen userInputScreen = new UserInputScreen();

    private static LottoResultScreen lottoResultScreen = new LottoResultScreen();

    public int queryPurchaseAmount() throws IOException {
        return userInputScreen.queryPurchaseAmount();
    }

    public List<Integer> queryWinningLotto() throws IOException {
        return userInputScreen.queryWinningLotto();
    }

    public int queryBonusNumber() throws IOException {
        return userInputScreen.queryBonusNumber();
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(String.format("%s개를 구매했습니다.", lottoTickets.getSize()));
        lottoTickets.getLottoTickets().forEach(System.out::println);
    }

    public void printLottoResults(WinningResultResponse lottoGameResponse) {
        lottoResultScreen.printLottoResults(lottoGameResponse);
    }
}
