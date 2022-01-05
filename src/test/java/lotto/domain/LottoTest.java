package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static lotto.domain.DomainValidationChecker.NUM_OF_LOTTO_NUMBERS_IN_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    Lotto standardLotto;

    @BeforeEach
    void setUp() {
        standardLotto = new Lotto(Arrays.stream(new int[]{2, 4, 6, 8, 10, 12})
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    @DisplayName("두 로또 사이에 일치하는 번호 개수가 6개(로또번호 개수) 이하인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"2,4,6,8,10,12", "1,2,3,4,5,6"})
    void getNumOfMatchingNumbersWith(String numbers) {
        Lotto compareLotto = new Lotto(DomainValidationCheckerTest.getLottoNumberListFromString(numbers));
        assertThat(standardLotto.getNumOfMatchingNumbersWith(compareLotto) <= NUM_OF_LOTTO_NUMBERS_IN_LOTTO).isEqualTo(true);
    }

    @DisplayName("로또가 특정 번호를 포함하고 있는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:true", "3:false", "4:true"}, delimiter = ':')
    void containsLottoNumber(int number, boolean expected) {
        assertThat(standardLotto.containsLottoNumber(new LottoNumber(number))).isEqualTo(expected);
    }
}