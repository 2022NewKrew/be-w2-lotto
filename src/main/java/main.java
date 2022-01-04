import domain.*;
import view.LottoView;
import view.MatchingView;
import view.PlayerView;

import java.util.*;

public class main {
    private static Player player;
    private static int payPrice;
    private static PlayerView playerView = new PlayerView();
    private static LottoView lottoView = new LottoView();
    private static Matching matching = new Matching();
    private static MatchingView matchingView = new MatchingView();

    public static void main(String[] args) {
        player = new Player(payPrice = UserInput.getPayPriceInput());
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
        playerView.PrintLottoSize(player.getLottoList().size());
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
        EnumMap<Prize, Long> matchingMap = matching.getMatchingMap();
        matchingView.PrintMatchResult(matchingMap, payPrice);
    }
}