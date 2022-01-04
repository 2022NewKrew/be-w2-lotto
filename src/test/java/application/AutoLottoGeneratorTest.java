package application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AutoLottoGeneratorTest {

    @DisplayName("정상적으로 자동 로또가 생성되는지 검증")
    @Test
    void isValidLottoCreated() {
        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        assertDoesNotThrow(lottoGenerator::getLotto);    // 정상적(중복X, 유효 범위)으로 로또를 생성하면 예외가 발생하지 않는다
    }
}