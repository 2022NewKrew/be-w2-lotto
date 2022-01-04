package bin.jaden.be_w2_lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    public void lottoTest() {
        // given
        int purchasingAmount = 202201;

        // when
        Lotto lotto = new Lotto(purchasingAmount);

        // then
        assertThat(lotto.getLottoGames().size()).isEqualTo(purchasingAmount / Constants.PRICE_PER_GAME);
    }
}
