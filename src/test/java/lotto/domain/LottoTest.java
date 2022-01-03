package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void createLotto() {
        // Given

        // When
        Lotto lotto = new Lotto(14000);

        // Then
        Assertions.assertEquals(14, lotto.getLottoCount());
    }

    @DisplayName("로또 개수 get 메소드 테스트")
    @Test
    void getLottoCount() {
        // Given
        Lotto lotto = new Lotto(14000);

        // When
        Integer result = lotto.getLottoCount();

        //Then
        Assertions.assertEquals(14, result);
    }

    @DisplayName("getLottoRows 메소드 테스트")
    @Test
    void getLottoRows() {
        // Given
        Lotto lotto = new Lotto(14000);

        // When
        List<LottoRow> result = lotto.getLottoRows();

        //Then
        Assertions.assertEquals(14, result.size());
    }

    @DisplayName("로또 전체 가격 조회 메소드 테스트")
    @Test
    void getWholeLottoPrice() {
        // Given
        Lotto lotto = new Lotto(14000);

        // When
        Integer result = lotto.getWholeLottoPrice();

        //Then
        Assertions.assertEquals(14000, result);
    }

    @DisplayName("LottoWinningResult get 메소드 테스트 - Nothing이 널인지 확인")
    @Test
    void getLottoWinningResultWithNothingEnum() {
        // Given
        Lotto lotto = new Lotto(14000);

        // When
        LottoWinningResult lottoWinningResult = lotto.getLottoWinningResult();

        //Then
        Assertions.assertThrows(NullPointerException.class, () -> {
            lottoWinningResult.getLottoWinningCount(LottoWinningRating.NOTHING);
        });
    }
}