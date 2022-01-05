package view;

import view.dto.LottoPurchaseResponse;
import domain.LottoTickets;
import view.dto.WinningResultResponse;
import view.screen.LottoResultScreen;
import view.screen.UserInputScreen;

import java.io.IOException;
import java.util.List;

public class LottoGameView {

    private static final String MESSAGE_PRINT_LOTTO_TICKETS = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    private static UserInputScreen userInputScreen = new UserInputScreen();

    private static LottoResultScreen lottoResultScreen = new LottoResultScreen();

    public int queryPurchaseAmount() throws IOException {
        return userInputScreen.queryPurchaseAmount();
    }

    public int queryManualLottoCount() throws IOException {
        return userInputScreen.queryManualLottoCount();
    }

    public List<List<Integer>> queryManualLottoNumbers(int lottoCount) throws IOException {
        return userInputScreen.queryManualLottoNumbers(lottoCount);
    }

    public List<Integer> queryWinningLotto() throws IOException {
        return userInputScreen.queryWinningLotto();
    }

    public int queryBonusNumber() throws IOException {
        return userInputScreen.queryBonusNumber();
    }

    public void printLottoTickets(LottoPurchaseResponse purchaseResponse) {
        LottoTickets lottoTickets = purchaseResponse.getLottoTickets();
        int manualLottoCount = purchaseResponse.getManualLottoCount();
        int autoLottoCount = lottoTickets.getSize() - manualLottoCount;

        System.out.println();
        System.out.println(String.format(MESSAGE_PRINT_LOTTO_TICKETS, manualLottoCount, autoLottoCount));
        lottoTickets.getLottoTickets().forEach(System.out::println);
    }

    public void printLottoResults(WinningResultResponse lottoGameResponse) {
        lottoResultScreen.printLottoResults(lottoGameResponse);
    }
}
