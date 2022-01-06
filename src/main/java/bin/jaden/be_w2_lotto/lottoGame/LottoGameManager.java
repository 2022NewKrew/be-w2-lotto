package bin.jaden.be_w2_lotto.lottoGame;

import bin.jaden.be_w2_lotto.data.Constants;
import bin.jaden.be_w2_lotto.data.LottoGameResult;
import bin.jaden.be_w2_lotto.data.LottoRankEnum;

import java.util.*;

public class LottoGameManager {
    private final List<LottoGame> lottoGames;
    private final int numberOfPurchaseManually;
    private final int purchasingAmount;

    public LottoGameManager(int purchasingAmount, List<ManualLottoGame> manualLottoGames) {
        int size = purchasingAmount / Constants.PRICE_PER_GAME - manualLottoGames.size();
        List<LottoGame> lottoGames = new ArrayList<>(manualLottoGames);

        AutoLottoGame.initAllNumbers();
        for (int i = 0; i < size; i++) {
            lottoGames.add(new AutoLottoGame());
        }
        this.numberOfPurchaseManually = manualLottoGames.size();
        this.lottoGames = Collections.unmodifiableList(lottoGames);
        this.purchasingAmount = purchasingAmount / Constants.PRICE_PER_GAME * Constants.PRICE_PER_GAME;
    }

    private static int getCount(List<Integer> lottoGame, List<Integer> winNumbers) {
        int count = 0;
        for (int winNumber : winNumbers) {
            count = lottoGame.contains(winNumber) ? count + 1 : count;
        }
        return count;
    }

    public List<LottoGameResult> getResults(WinLottoGame winLottoGame) {
        List<LottoGameResult> resultList = new ArrayList<>();
        Map<LottoRankEnum, Integer> resultMap = new HashMap<>();

        int bonusNumber = winLottoGame.getBonusNumber();
        for (LottoGame lottoGame : lottoGames) {
            int count = getCount(lottoGame.getNumbers(), winLottoGame.getNumbers());
            LottoRankEnum rank = LottoRankEnum.getRank(count, lottoGame.getNumbers().contains(bonusNumber));
            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
        resultList.add(new LottoGameResult(resultMap, purchasingAmount));
        return Collections.unmodifiableList(resultList);
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }

    public int getNumberOfPurchaseManually() {
        return numberOfPurchaseManually;
    }

    public int getNumberOfPurchaseAuto() {
        return getNumberOfTotalPurchase() - getNumberOfPurchaseManually();
    }

    public int getNumberOfTotalPurchase() {
        return getLottoGames().size();
    }

}
