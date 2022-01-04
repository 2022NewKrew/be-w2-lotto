package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoTicketTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void createLotto() {
        // Given

        // When
        LottoTicket lotto = new LottoTicket(14000);

        // Then
        Assertions.assertEquals(14, lotto.getLottoCount());
    }

    @DisplayName("로또 개수 get 메소드 테스트")
    @Test
    void getLottoCount() {
        // Given
        LottoTicket lotto = new LottoTicket(14000);

        // When
        Integer result = lotto.getLottoCount();

        //Then
        Assertions.assertEquals(14, result);
    }

    @DisplayName("getLottoRows 메소드 테스트")
    @Test
    void getLottoRows() {
        // Given
        LottoTicket lotto = new LottoTicket(14000);

        // When
        List<Lotto> result = lotto.getLottoList();

        //Then
        Assertions.assertEquals(14, result.size());
    }

    @DisplayName("로또 전체 가격 조회 메소드 테스트")
    @Test
    void getWholeLottoPrice() {
        // Given
        LottoTicket lotto = new LottoTicket(14000);

        // When
        Integer result = lotto.getWholeLottoPrice();

        //Then
        Assertions.assertEquals(14000, result);
    }

    @DisplayName("LottoWinningResult get 메소드 테스트 - Nothing이 널인지 확인")
    @Test
    void getLottoWinningResultWithNothingEnum() {
        // Given
        LottoTicket lotto = new LottoTicket(14000);
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        // When
        LottoWinningResult lottoWinningResult = lotto.getLottoWinningResult(winningNumbers);

        //Then
        Assertions.assertNull(lottoWinningResult.getLottoWinningCount(LottoWinningRating.NOTHING));
    }
}