package bin.jaden.be_w2_lotto.domain;

import bin.jaden.be_w2_lotto.LottoGame.AutoLottoGame;
import bin.jaden.be_w2_lotto.LottoGame.LottoGame;
import bin.jaden.be_w2_lotto.LottoGame.ManualLottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameManager {
    private final List<LottoGame> lottoGames;
    private final int numberOfPurchaseManually;

    LottoGameManager(int purchasingAmount, int numberOfPurchaseManually, List<ManualLottoGame> manualLottoGames) {
        int size = purchasingAmount / Constants.PRICE_PER_GAME - manualLottoGames.size();
        List<LottoGame> lottoGames = new ArrayList<>(manualLottoGames);

        AutoLottoGame.initAllNumbers();
        for (int i = 0; i < size; i++) {
            lottoGames.add(new AutoLottoGame());
        }
        this.numberOfPurchaseManually = numberOfPurchaseManually;
        this.lottoGames = Collections.unmodifiableList(lottoGames);
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

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }
}
