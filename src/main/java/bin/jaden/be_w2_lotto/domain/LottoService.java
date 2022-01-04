package bin.jaden.be_w2_lotto.domain;

import bin.jaden.be_w2_lotto.view.LottoPrinter;
import bin.jaden.be_w2_lotto.view.LottoScanner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static List<Integer> winNumbers;
    private static int bonusNumber;

    private LottoService() {
        // instance 생성 제한용 생성자
    }

    public static void startLotto() {
        int purchasingAmount = getPurchasingAmount();
        Lotto lotto = new Lotto(purchasingAmount);
        purchasingAmount = lotto.getLottoGames().size() * Constants.PRICE_PER_GAME; // 거스름돈을 무시하기 위해 구매한 (로또수 * 가격)을 한다.
        LottoPrinter.printLottoData(lotto);
        winNumbers = getWinNumbers();
        bonusNumber = getBonusNumber();
        Map<LottoRankEnum, Integer> result = getResult(lotto.getLottoGames());
        LottoPrinter.printResults(purchasingAmount, result);
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

    private static int getBonusNumber() {
        int bonusNumber = 0;
        while (bonusNumber == 0) {
            bonusNumber = LottoScanner.getBonusNumbers(winNumbers);
        }
        return bonusNumber;
    }

    private static Map<LottoRankEnum, Integer> getResult(List<LottoGame> lottoGames) {
        Map<LottoRankEnum, Integer> results = new HashMap<>();

        for (LottoGame lottoGame : lottoGames) {
            int count = getCount(lottoGame.getNumbers());
            setResult(results, count, lottoGame.getNumbers().contains(bonusNumber));
        }
        return Collections.unmodifiableMap(results);
    }

    private static void setResult(Map<LottoRankEnum, Integer> results, int count, boolean isBonus) {
        if (count > 2) {
            LottoRankEnum rank = getRank(count, isBonus);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
    }

    private static LottoRankEnum getRank(int count, boolean isBonus) {
        if (count == Constants.NUMBERS_PER_GAME) {
            return LottoRankEnum.LOTTO_RANK_1ST;
        }
        if (count == Constants.NUMBERS_PER_GAME - 1 && isBonus) {
            return LottoRankEnum.LOTTO_RANK_2ND;
        }
        return LottoRankEnum.values()[count - 3];
    }

    private static int getCount(List<Integer> lottoGame) {
        int count = 0;
        for (int winNumber : winNumbers) {
            count = lottoGame.contains(winNumber) ? count + 1 : count;
        }
        return count;
    }
}
