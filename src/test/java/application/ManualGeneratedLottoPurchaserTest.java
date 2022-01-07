package application;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManualGeneratedLottoPurchaserTest {

    @DisplayName("수동 입력한 공 리스트를 정상적으로 변환하는지 검증")
    @Test
    void isCorrectManualLottoNumberConvert() {
        List<List<Integer>> lottoNumbersList = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
        ManualGeneratedLottoPurchaser manualPurchaser = new ManualGeneratedLottoPurchaser(lottoNumbersList);

        List<Lotto> lottoList = manualPurchaser.generateLotto();

        assertThat(lottoList.get(0).getBalls())
                .extracting("number")
                .containsExactly(8, 21, 23, 41, 42, 43);
        assertThat(lottoList.get(1).getBalls())
                .extracting("number")
                .containsExactly(3, 5, 11, 16, 32, 38);
        assertThat(lottoList.get(2).getBalls())
                .extracting("number")
                .containsExactly(7, 11, 16, 35, 36, 44);
    }

    @DisplayName("유효하지 않은 공 번호가 들어올 때 에러를 반환하는지 검증")
    @Test
    void checkInvalidBallNumberComes() {
        List<List<Integer>> invalidLottoNumbersList = List.of(
                List.of(-1, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 46),
                List.of(7, 11, 16, 35, 36, 44)
        );
        ManualGeneratedLottoPurchaser manualPurchaser = new ManualGeneratedLottoPurchaser(invalidLottoNumbersList);

        assertThrows(IllegalArgumentException.class, manualPurchaser::generateLotto);
    }

    @DisplayName("중복된 공 번호 들어올 때 에러를 반환하는지 검증")
    @Test
    void checkDuplicatedBallNumberComes() {
        List<List<Integer>> invalidLottoNumbersList = List.of(
                List.of(21, 21, 23, 41, 42, 43)
        );
        ManualGeneratedLottoPurchaser manualPurchaser = new ManualGeneratedLottoPurchaser(invalidLottoNumbersList);

        assertThrows(IllegalArgumentException.class, manualPurchaser::generateLotto);
    }

    @DisplayName("들어온 공 개수가 올바르지 않을 때 에러를 반환하는지 검증")
    @Test
    void checkInvalidBallsCountComes() {
        List<List<Integer>> invalidLottoNumbersList = List.of(
                List.of(21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 46),
                List.of(7, 11, 16, 35, 36, 44)
        );
        ManualGeneratedLottoPurchaser manualPurchaser = new ManualGeneratedLottoPurchaser(invalidLottoNumbersList);

        assertThrows(IllegalArgumentException.class, manualPurchaser::generateLotto);
    }

}