package bin.jaden.be_w2_lotto.domain;

import bin.jaden.be_w2_lotto.LottoGame.ManualLottoGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    public void lottoTest() {
        // given
        int purchasingAmount = 202201;
        int numberOfPurchaseManually = 0;
        List<ManualLottoGame> manualLottoGames = new ArrayList<>();

        // when
        LottoGameManager lotto = new LottoGameManager(purchasingAmount, numberOfPurchaseManually, manualLottoGames);

        // then
        assertThat(lotto.getLottoGames().size()).isEqualTo(purchasingAmount / Constants.PRICE_PER_GAME);
    }
}
