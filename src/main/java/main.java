import domain.*;
import view.LottoView;
import view.MatchingView;
import view.PlayerView;

import java.util.*;


public class main {
    private static int playerMoney;
    private static int payManualCount;
    private static int payAutoCount;
    public static final int LOTTO_PRICE = 1000;
    private static Player player;
    private static PlayerView playerView = new PlayerView();
    private static LottoView lottoView = new LottoView();
    private static Matching matching = new Matching();
    private static MatchingView matchingView = new MatchingView();

    public static void main(String[] args) {
        playerMoney = UserInput.getPayPriceInput();
        payManualCount = UserInput.getManualCountInput(playerMoney/LOTTO_PRICE);
        payAutoCount = (playerMoney - payManualCount*LOTTO_PRICE) / LOTTO_PRICE;

        List<Lotto> manualLottoList  = UserInput.getManualLottoInput(payManualCount);

        player = new Player(payAutoCount, manualLottoList);
        printLottoList();
        printLottoSize();
        addMatchingLotto();
        printMatchingResult();
    }

    private static void printLottoList() {
        List<Lotto> lottoList = player.getLottoList();
        for (Lotto lotto : lottoList) {
            lottoView.printLottoNumber(lotto.getNumberList());
        }
    }

    private static void printLottoSize() {
        playerView.PrintLottoSize(payAutoCount, payManualCount);
    }

    private static void addMatchingLotto() {
        List<Integer> winningNumber = UserInput.getWinningInput();
        Integer bonusNumber = UserInput.getBonusWinningInput();
        List<Integer> matchingLottos = player.matchingLotto(winningNumber);
        List<Boolean> matchingBonusLottos = player.matchingBonusLotto(bonusNumber);
        for (int i = 0; i < matchingLottos.size(); i++) {
            Prize prize = Prize.getPrize(matchingLottos.get(i), matchingBonusLottos.get(i));
            matching.addMatchingMap(prize);
        }
    }

    private static void printMatchingResult() {
        matchingView.PrintMatchResult(matching, playerMoney);
    }
}