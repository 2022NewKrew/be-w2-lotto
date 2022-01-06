package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성시 purchaseAmount에 맞도록 lottoCount가 반환되는 지 테스트 - purchaseAmount가 15000이고 manual Number Texts 가 1개 인경우 15를 리턴")
    @Test
    void lottoTicket_PurchaseAmount15000AndManualLottoNumberTexts_getLottoCount15() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(1);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);
        manualLottoNumber.add(6);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);

        // When
        LottoTicket lottoTicket = new LottoTicket(15000, manualLottoNumbers);

        // Then
        Assertions.assertEquals(15, lottoTicket.getLottoCount());
    }

    @DisplayName("로또 개수 get 메소드 테스트 - purchaseAmount가 15000이고 manual Number Texts 가 1개 인경우 15를 리턴")
    @Test
    void getLottoCount_PurchaseAmount15000AndManualLottoNumberTexts_15() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(1);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);
        manualLottoNumber.add(6);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);

        LottoTicket lottoTicket = new LottoTicket(15000, manualLottoNumbers);

        // When
        int result = lottoTicket.getLottoCount();

        //Then
        Assertions.assertEquals(15, result);
    }

    @DisplayName("getLottoList 메소드 테스트 - purchaseAmount가 14000이고 manual Number Texts 가 1개 인경우 size가 14를 리턴 ")
    @Test
    void getLottoList_PurchaseAmount14000AndManualLottoNumberTexts_ListSize14() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(1);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);
        manualLottoNumber.add(6);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);

        LottoTicket lottoTicket = new LottoTicket(14000, manualLottoNumbers);

        // When
        List<Lotto> result = lottoTicket.getLottoList();

        //Then
        Assertions.assertEquals(14, result.size());
    }

    @DisplayName("로또 전체 가격 조회 메소드 테스트 - purchaseAmount가 14000이고 manual Number Texts 가 1개 인경우 14000을 리턴")
    @Test
    void getWholeLottoPrice_PurchaseAmount14_14000() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(1);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);
        manualLottoNumber.add(6);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);

        LottoTicket lottoTicket = new LottoTicket(14000, manualLottoNumbers);

        // When
        int result = lottoTicket.getWholeLottoPrice();

        //Then
        Assertions.assertEquals(14000, result);
    }

    @DisplayName("LottoWinningResult get 메소드 테스트 - purchaseAmount가 14000이고 manual Texts 가 1개 인경우 FOURTH의 WinningCount가 14이하인지 확인")
    @Test
    void getLottoWinningResult_PurchaseAmount14000_WinningCountUnder14() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(1);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);
        manualLottoNumber.add(6);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);

        LottoTicket lottoTicket = new LottoTicket(14000, manualLottoNumbers);
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

    @DisplayName("getLottoList 테스트 - purchaseAmount가 14000이고, MannualLottoNumberText가 1개 있을 때, lottoListSize가 14")
    @Test
    void getLottoList_PurchaseAmount14000AndManualLottoNumberTexts_lottoListSizeIs14() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(1);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);
        manualLottoNumber.add(6);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);
        LottoTicket lottoTicket = new LottoTicket(14000, manualLottoNumbers);

        // When
        List<Lotto> lottoList = lottoTicket.getLottoList();

        // Then
        Assertions.assertEquals(14, lottoList.size());
    }

    @DisplayName("로또 티켓 생성 테스트 - purchaseAmount가 1000이고 manual Number Texts에 45초과인 숫자가 포함되면 IllegalArgumentException 발생")
    @Test
    void lottoTicket_PurchaseAmount1000AndManualLottoNumberTextsContainOver45_ThrowIllegalArgumentException() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(1);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);
        manualLottoNumber.add(46);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);

        // When // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LottoTicket(1000, manualLottoNumbers);
        });
    }

    @DisplayName("로또 티켓 생성 테스트 - purchaseAmount가 1000이고 manual Number Texts에 1미만인 숫자가 포함되면 IllegalArgumentException 발생")
    @Test
    void lottoTicket_PurchaseAmount1000AndManualLottoNumberTextsContainUnder1_ThrowIllegalArgumentException() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(0);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);
        manualLottoNumber.add(6);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);

        // When // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LottoTicket(1000, manualLottoNumbers);
        });
    }

    @DisplayName("로또 티켓 생성 테스트 - purchaseAmount가 1000이고 manual Number Texts에 6개 초과의 숫자가 포함되어있으면 IllegalArgumentException 발생")
    @Test
    void lottoTicket_PurchaseAmount1000AndManualLottoNumberTextsCountOver6_ThrowIllegalArgumentException() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(1);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);
        manualLottoNumber.add(6);
        manualLottoNumber.add(7);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);

        // When // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LottoTicket(1000, manualLottoNumbers);
        });
    }

    @DisplayName("로또 티켓 생성 테스트 - purchaseAmount가 1000이고 manual Number Texts에 6개 미만의 숫자가 포함되어있으면 IllegalArgumentException 발생")
    @Test
    void lottoTicket_PurchaseAmount1000AndManualLottoNumberTextsCountUnder6_ThrowIllegalArgumentException() {
        // Given
        List<Integer> manualLottoNumber = new ArrayList<>();
        manualLottoNumber.add(1);
        manualLottoNumber.add(2);
        manualLottoNumber.add(3);
        manualLottoNumber.add(4);
        manualLottoNumber.add(5);

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manualLottoNumber);

        // When // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LottoTicket(1000, manualLottoNumbers);
        });
    }

}
