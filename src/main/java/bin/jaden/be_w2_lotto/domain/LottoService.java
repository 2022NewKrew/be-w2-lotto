package bin.jaden.be_w2_lotto.domain;

import bin.jaden.be_w2_lotto.view.LottoPrinter;
import bin.jaden.be_w2_lotto.view.LottoScanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private static List<Integer> winNumbers;

    private LottoService() {
        // instance 생성 제한용 생성자
    }

    public static void startLotto() {
        int purchasingAmount = getPurchasingAmount();
        Lotto lotto = new Lotto(purchasingAmount);
        purchasingAmount = lotto.getLottoGames().size() * Constants.PRICE_PER_GAME; // 거스름돈을 무시하기 위해 구매한 (로또수 * 가격)을 한다.
        LottoPrinter.printLottoData(lotto);
        winNumbers = getWinNumbers();
        List<Integer> result = getResult(lotto.getLottoGames());
        LottoPrinter.printResult(purchasingAmount, result);
    }

    private static int getPurchasingAmount() {
        int purchasingAmount = -1;
        while (purchasingAmount < 0) {
            purchasingAmount = LottoScanner.getPurchasingAmount();
        }
        return purchasingAmount;
    }

    private static List<Integer> getWinNumbers() {
        List<Integer> winNumbers = null;
        while (winNumbers == null) {
            winNumbers = LottoScanner.getWinNumbers();
        }
        return winNumbers;
    }

    private static List<Integer> getResult(List<List<Integer>> lottoGames) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= Constants.NUMBERS_PER_GAME; i++) {
            result.add(0);
        }
        for (List<Integer> lottoGame : lottoGames) {
            int count = getCount(lottoGame);
            result.set(count, result.get(count) + 1);
        }
        return Collections.unmodifiableList(result);
    }

    private static int getCount(List<Integer> lottoGame) {
        int count = 0;
        for (int winNumber : winNumbers) {
            count = lottoGame.contains(winNumber) ? count + 1 : count;
        }
        return count;
    }
}
