package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoTicketTest {

    @DisplayName("로또 생성시 purchaseAmount에 맞도록 lottoCount가 반환되는 지 테스트")
    @Test
    void lotto_PurchaseAmount14000_getLottoCount14() {
        // Given

        // When
        LottoTicket lottoTicket = new LottoTicket(14000);

        // Then
        Assertions.assertEquals(14, lottoTicket.getLottoCount());
    }

    @DisplayName("로또 개수 get 메소드 테스트")
    @Test
    void getLottoCount_PurchaseAmount14000_14() {
        // Given
        LottoTicket lottoTicket = new LottoTicket(14000);

        // When
        int result = lottoTicket.getLottoCount();

        //Then
        Assertions.assertEquals(14, result);
    }

    @DisplayName("getLottoRows 메소드 테스트")
    @Test
    void getLottoList_PurchaseAmount14000_ListSize14() {
        // Given
        LottoTicket lottoTicket = new LottoTicket(14000);

        // When
        List<Lotto> result = lottoTicket.getLottoList();

        //Then
        Assertions.assertEquals(14, result.size());
    }

    @DisplayName("로또 전체 가격 조회 메소드 테스트")
    @Test
    void getWholeLottoPrice_PurchaseAmount14_14000() {
        // Given
        LottoTicket lottoTicket = new LottoTicket(14000);

        // When
        int result = lottoTicket.getWholeLottoPrice();

        //Then
        Assertions.assertEquals(14000, result);
    }

    @DisplayName("LottoWinningResult get 메소드 테스트 - FOURTH의 WinningCount가 14이하인지 확인")
    @Test
    void getLottoWinningResultWithNothingEnum_PurchaseAmount14000_WinningCountUnder14() {
        // Given
        LottoTicket lottoTicket = new LottoTicket(14000);
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        int bonusBallNumber = 7;

        // When
        LottoWinningResult lottoWinningResult = lottoTicket.getLottoWinningResult(winningNumbers, bonusBallNumber);

        //Then
        Assertions.assertTrue(lottoWinningResult.getLottoWinningCount(LottoWinningRating.FOURTH) <= 14);
    }

}
