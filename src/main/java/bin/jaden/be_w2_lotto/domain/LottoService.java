package bin.jaden.be_w2_lotto.domain;

import bin.jaden.be_w2_lotto.LottoGame.LottoGame;
import bin.jaden.be_w2_lotto.LottoGame.ManualLottoGame;
import bin.jaden.be_w2_lotto.LottoGame.WinLottoGame;
import bin.jaden.be_w2_lotto.view.LottoPrinter;
import bin.jaden.be_w2_lotto.view.LottoScanner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private LottoService() {
        // instance 생성 제한용 생성자
    }

    public static void startLotto() {
        LottoGameManager lottoGameManager = getLottoManager();
        int purchasingAmount = lottoGameManager.getLottoGames().size() * Constants.PRICE_PER_GAME; // 거스름돈을 무시하기 위해 구매한 (로또 수 * 가격)을 한다.
        LottoPrinter.printLottoData(lottoGameManager);
        WinLottoGame winLottoGame = getWinLottoGame();
        printResult(purchasingAmount, lottoGameManager.getLottoGames(), winLottoGame);
    }

    private static LottoGameManager getLottoManager() {
        int purchasingAmount = getPurchasingAmount();
        int numberOfPurchaseManually = getNumberOfPurchaseManually(purchasingAmount / Constants.PRICE_PER_GAME);
        List<ManualLottoGame> manualLottoGames = LottoScanner.getManualLottoGames(numberOfPurchaseManually);

        return new LottoGameManager(purchasingAmount, numberOfPurchaseManually, manualLottoGames);
    }

    private static WinLottoGame getWinLottoGame() {
        List<Integer> winNumbers = getWinNumbers();
        int bonusNumber = getBonusNumber(winNumbers);
        return new WinLottoGame(winNumbers, bonusNumber);
    }

    private static void printResult(int purchasingAmount, List<LottoGame> lottoGames, WinLottoGame winLottoGame) {
        Map<LottoRankEnum, Integer> result = getResult(lottoGames, winLottoGame);
        LottoPrinter.printResults(purchasingAmount, result);
    }

    private static int getPurchasingAmount() {
        int purchasingAmount = -1;
        while (purchasingAmount < 0) {
            purchasingAmount = LottoScanner.getPurchasingAmount();
        }
        return purchasingAmount;
    }

    private static int getNumberOfPurchaseManually(int totalLottos) {
        int numberOfPurchaseManually = -1;
        while (numberOfPurchaseManually < 0) {
            numberOfPurchaseManually = LottoScanner.getNumberOfPurchaseManually(totalLottos);
        }
        return numberOfPurchaseManually;
    }

    private static List<Integer> getWinNumbers() {
        List<Integer> winNumbers = null;
        while (winNumbers == null) {
            winNumbers = LottoScanner.getWinNumbers();
        }
        return winNumbers;
    }

    private static int getBonusNumber(List<Integer> winNumbers) {
        int bonusNumber = 0;
        while (bonusNumber == 0) {
            bonusNumber = LottoScanner.getBonusNumbers(winNumbers);
        }
        return bonusNumber;
    }

    private static Map<LottoRankEnum, Integer> getResult(List<LottoGame> lottoGames, WinLottoGame winLottoGame) {
        Map<LottoRankEnum, Integer> results = new HashMap<>();

        int bonusNumber = winLottoGame.getBonusNumber();
        for (LottoGame lottoGame : lottoGames) {
            int count = getCount(lottoGame.getNumbers(), winLottoGame.getNumbers());
            LottoRankEnum rank = LottoRankEnum.getRank(count, lottoGame.getNumbers().contains(bonusNumber));
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return Collections.unmodifiableMap(results);
    }

    private static int getCount(List<Integer> lottoGame, List<Integer> winNumbers) {
        int count = 0;
        for (int winNumber : winNumbers) {
            count = lottoGame.contains(winNumber) ? count + 1 : count;
        }
        return count;
    }
}
