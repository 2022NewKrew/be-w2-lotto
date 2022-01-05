package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @DisplayName("null 값을 리턴하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"0,true", "3,true", "1,false", "4,true"}, delimiter = ',')
    void getResult(int numOfMatchings, boolean bonusMatching) {
        assertNotNull(LottoResult.getResult(numOfMatchings, bonusMatching));
    }
}