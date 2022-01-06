package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoSimulator.SEPARATOR;
import static lotto.domain.DomainValidationChecker.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DomainValidationCheckerTest {
    DomainValidationChecker checker;

    public static List<LottoNumber> getLottoNumberListFromString(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(s -> Integer.parseInt(s.trim()))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @BeforeEach
    void setUp() {
        checker = new DomainValidationChecker();
    }

    @DisplayName("6개의 로또 번호가 주어졌을 때 각 로또 번호가 1~45 사이의 값이 아닐때 올바른 Exception 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "41,42,43,44,45,46"})
    void checkLottoNumbersInLotto1(String numbers) {
        List<LottoNumber> lottoNumberList = getLottoNumberListFromString(numbers);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> checker.checkLottoNumbersInLotto(lottoNumberList));
        assertEquals(iae.getMessage(), CHECK_LOTTO_NUMBER_MESSAGE);
    }

    @DisplayName("하나의 로또 번호가 주어졌을 때 해당 번호가 1~45 사이의 값인지 아닌지 확인")
    @ParameterizedTest
    @CsvSource(value = {"-5:false", "0:false", "46:false", "30:true"}, delimiter = ':')
    void checkLottoNumber(int number, boolean expected) {
        assertThat(checker.checkLottoNumber(new LottoNumber(number))).isEqualTo(expected);
    }

    @DisplayName("6개의 로또 번호 사이에 중복이 있을 경우 올바른 Exception 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "41,42,43,44,45,45"})
    void checkDuplicationInLotto(String numbers) {
        List<LottoNumber> lottoNumberList = getLottoNumberListFromString(numbers);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> checker.checkDuplicationInLotto(lottoNumberList));
        assertEquals(iae.getMessage(), CHECK_DUPLICATION_MESSAGE);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 올바른 Exception 발생하는지 확인")
    @Test
    void checkDuplicationInWinningLotto() {
        List<LottoNumber> lottoNumberList = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(3);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> checker.checkDuplicationInWinningLotto(new Lotto(lottoNumberList), bonusNumber));
        assertEquals(iae.getMessage(), CHECK_DUPLICATION_MESSAGE);
    }

    @DisplayName("로또 번호가 6개가 아닌 경우 올바른 Exception이 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "39,40,41,42,43,44,45"})
    void checkNumOfLottoNumbers(String numbers) {
        List<LottoNumber> lottoNumberList = getLottoNumberListFromString(numbers);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> checker.checkNumOfLottoNumbers(lottoNumberList));
        assertEquals(iae.getMessage(), CHECK_NUM_OF_LOTTO_NUMBERS);
    }
}