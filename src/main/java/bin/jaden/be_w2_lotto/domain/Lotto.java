package bin.jaden.be_w2_lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoGame> lottoGames;

    Lotto(int purchasingAmount) {
        LottoGame.initAllNumbers();
        int size = purchasingAmount / Constants.PRICE_PER_GAME;
        List<LottoGame> lottoGames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoGames.add(new LottoGame());
        }
        this.lottoGames = Collections.unmodifiableList(lottoGames);
    }


    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }
}
