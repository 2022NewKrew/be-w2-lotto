package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    LottoNumber standardLottoNumber;

    @BeforeEach
    void setUp() {
        standardLottoNumber = new LottoNumber(15);
    }

    @DisplayName("두 로또 번호의 대소 비교 확인")
    @ParameterizedTest
    @ValueSource(ints = {10,15,20})
    void compareTo(int number) {
        LottoNumber compareLottoNumber = new LottoNumber(number);
        assertThat(standardLottoNumber.compareTo(compareLottoNumber)).isEqualTo(Integer.compare(standardLottoNumber.getNumber(),compareLottoNumber.getNumber()));
    }

    @DisplayName("두 로또 번호가 같은지 비교")
    @ParameterizedTest
    @ValueSource(ints = {10,15,20})
    void testEquals(int number) {
        LottoNumber compareLottoNumber = new LottoNumber(number);
        assertThat(standardLottoNumber.equals(compareLottoNumber)).isEqualTo(standardLottoNumber.getNumber() == compareLottoNumber.getNumber());
    }
}