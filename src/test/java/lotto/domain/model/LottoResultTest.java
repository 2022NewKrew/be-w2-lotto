package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {
    private final static int BONUS_BALL = 7;
    private final static int PURCHASE_PRICE = 1000;
    private final double EXPECTED = 400;
    private final static List<Integer> WINNING_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private final static List<Integer> MATCH_LOTTO_NUMBERS = List.of(1, 2, 3, 7, 8, 9);

    @Test
    @DisplayName("구매금액과 당첨금액에 맞는 이익률을 반환해야한다.")
    void of_CalculateTotalRateOfReturn_ReturnExpected() throws Exception {
        // given
        final Constructor method = Lottos.class.getDeclaredConstructor(List.class);
        method.setAccessible(true);

        final List<Lotto> allLotto = List.of(
                new Lotto(MATCH_LOTTO_NUMBERS)
        );

        Lottos lottos = (Lottos) method.newInstance(allLotto);
        WinningLotto winningLotto = new WinningLotto(BONUS_BALL, WINNING_LOTTO_NUMBERS);

        // when
        LottoResult lottoResult = LottoResult.of(PURCHASE_PRICE, winningLotto, lottos);

        // then
        assertThat(lottoResult.getTotalRateOfReturn()).isEqualTo(EXPECTED);
    }
}