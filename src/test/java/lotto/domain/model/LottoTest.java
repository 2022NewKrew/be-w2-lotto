package lotto.domain.model;

import static lotto.domain.helper.LottoNumberHelper.convertNumbersToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private static final List<Integer> DUPLICATE_NUMBERS = List.of(1, 2, 3, 4, 5, 5);
    private static final List<Integer> NOT_ENOUGH_NUMBERS = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> TOO_MANY_NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7);

    private static final String DUPLICATE_ERROR_MESSAGE = "중복";
    private static final String SIZE_ERROR_MESSAGE = "6개";

    @DisplayName("로또 생성 시 값 중복 검증 테스트")
    @Test
    void fromTest() {
        // Given
        List<LottoNumber> lottoNumbers = convertNumbersToLottoNumbers(DUPLICATE_NUMBERS);

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Lotto.from(lottoNumbers));

        // Then
        assertThat(exception.getMessage())
            .contains(DUPLICATE_ERROR_MESSAGE);
    }

    @DisplayName("6개 미만의 숫자로 로또 생성 테스트")
    @Test
    void fromTest2() {
        // Given
        List<LottoNumber> lottoNumbers = convertNumbersToLottoNumbers(NOT_ENOUGH_NUMBERS);

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Lotto.from(lottoNumbers));

        // Then
        assertThat(exception.getMessage())
            .contains(SIZE_ERROR_MESSAGE);
    }

    @DisplayName("6개 초과 숫자로 로또 생성 테스트")
    @Test
    void fromTest3() {
        // Given
        List<LottoNumber> lottoNumbers = convertNumbersToLottoNumbers(TOO_MANY_NUMBERS);

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> Lotto.from(lottoNumbers));

        // Then
        assertThat(exception.getMessage())
            .contains(SIZE_ERROR_MESSAGE);
    }

    @DisplayName("hasNumber 동작 테스트")
    @Test
    void hasNumber() {
        // Given
        Lotto lotto = Lotto.from(convertNumbersToLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));

        LottoNumber numberInNumbers = LottoNumber.from(1);
        LottoNumber numberOutOfNumbers = LottoNumber.from(7);

        // When
        boolean estimateTrue = lotto.hasNumber(numberInNumbers);
        boolean estimateFalse = lotto.hasNumber(numberOutOfNumbers);

        // Then
        assertThat(estimateTrue)
            .isTrue();
        assertThat(estimateFalse)
            .isFalse();
    }

    @DisplayName("로또 번호 일치수 테스트")
    @Test
    void calculateMatchCountWith() {
        // Given
        Lotto lotto = Lotto.from(convertNumbersToLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lottoMatching3 = Lotto.from(convertNumbersToLottoNumbers(List.of(1, 2, 3, 7, 8, 9)));
        Lotto lottoMatching4 = Lotto.from(convertNumbersToLottoNumbers(List.of(1, 2, 3, 4, 7, 8)));
        Lotto lottoMatching5 = Lotto.from(convertNumbersToLottoNumbers(List.of(1, 2, 3, 4, 5, 7)));
        Lotto lottoMatching6 = Lotto.from(convertNumbersToLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));

        // When
        int estimate3 = lotto.calculateMatchCountWith(lottoMatching3);
        int estimate4 = lotto.calculateMatchCountWith(lottoMatching4);
        int estimate5 = lotto.calculateMatchCountWith(lottoMatching5);
        int estimate6 = lotto.calculateMatchCountWith(lottoMatching6);

        // Then
        assertThat(estimate3)
            .isEqualTo(3);
        assertThat(estimate4)
            .isEqualTo(4);
        assertThat(estimate5)
            .isEqualTo(5);
        assertThat(estimate6)
            .isEqualTo(6);
    }
}