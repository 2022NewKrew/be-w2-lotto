package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoTest {

    @DisplayName("로또 한줄 생성 테스트 - lottoNumbers 크기가 6인지 확인")
    @Test
    void createLotto_CreateLotto_NumbersSize6() {
        // Given

        // When
        Lotto lotto = new Lotto();

        // Then
        Assertions.assertEquals(6, lotto.getLottoNumbers().size());
    }

    @DisplayName("LottoNumbers get 메소드 테스트 - lottoNumbers 크기가 6인지 확인")
    @Test
    void getLottoNumbers_CreateLotto_NumbersSize6() {
        // Given
        Lotto lotto = new Lotto();

        // When
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        // Then
        Assertions.assertEquals(6, lottoNumbers.size());
    }

    @DisplayName("로또 등급 get 메소드 테스트 - winningRating이 Enum의 상태에 속하는지 확인")
    @Test
    void getWinningRating_WinningNumber123456_ResultCompareListContainWinningRating() {
        // Given
        Lotto lotto = new Lotto();
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        List<LottoWinningRating> resultCompareList = new ArrayList<>();
        resultCompareList.add(LottoWinningRating.FIRST);
        resultCompareList.add(LottoWinningRating.SECOND);
        resultCompareList.add(LottoWinningRating.THIRD);
        resultCompareList.add(LottoWinningRating.FIRST);
        resultCompareList.add(LottoWinningRating.NOTHING);

        int bonusBallNumber = 7;

        // When
        LottoWinningRating winningRating = lotto.getWinningRating(winningNumbers, bonusBallNumber);

        // Then
        Assertions.assertTrue(resultCompareList.contains(winningRating));
    }

    @DisplayName("로또 생성 테스트 - manual Number Texts에 가 6개의 숫자가 입력되면 size가 6을 반환")
    @Test
    void createLotto_ManualLottoNumberTextWithCount6_lottoNumbersSizeIs6() {
        // Given
        String manualLottoNumberText = "1, 2, 3, 4, 5, 6";

        // When
        Lotto lotto = new Lotto(manualLottoNumberText);

        // Then
        Assertions.assertEquals(6, lotto.getLottoNumbers().size());
    }

    @DisplayName("로또 생성 테스트 - manual Number Texts에 가 5개의 숫자가 입력되면 IllegalArgumentException 발생")
    @Test
    void createLotto_ManualLottoNumberTextWithCount5_ThrowIllegalArgumentException() {
        // Given
        String manualLottoNumberText = "1, 2, 3, 4, 5";

        // When // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(manualLottoNumberText);
        });
    }

    @DisplayName("로또 생성 테스트 - manual Number Texts에 가 7개의 숫자가 입력되면 IllegalArgumentException 발생")
    @Test
    void createLotto_ManualLottoNumberTextWithCount7_ThrowIllegalArgumentException() {
        // Given
        String manualLottoNumberText = "1, 2, 3, 4, 5, 6, 7";

        // When // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(manualLottoNumberText);
        });
    }

    @DisplayName("로또 생성 테스트 - manual Number Texts에 가 45초과의 숫자가 포함되면 IllegalArgumentException 발생")
    @Test
    void createLotto_ManualLottoNumberTextContainNumberOver45_ThrowIllegalArgumentException() {
        // Given
        String manualLottoNumberText = "1, 2, 3, 4, 5, 46";

        // When // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(manualLottoNumberText);
        });
    }

    @DisplayName("로또 생성 테스트 - manual Number Texts에 가 1미만의 숫자가 포함되면 IllegalArgumentException 발생")
    @Test
    void createLotto_ManualLottoNumberTextContainNumberUnder1_ThrowIllegalArgumentException() {
        // Given
        String manualLottoNumberText = "0, 2, 3, 4, 5, 6";

        // When // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(manualLottoNumberText);
        });
    }

}
