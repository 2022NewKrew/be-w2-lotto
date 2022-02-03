package service;

import exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoInfoServiceTest {

    @DisplayName("금액 입력 시 정수가 아니거나 1000원 이하의 입력이 들어올 때")
    @ValueSource(strings = {"abc", "10000.1", "?", "-100", "0", "100"})
    @ParameterizedTest
    void setMoneyTest(String input) {
        LottoInfoService lottoInfoService = new LottoInfoService();

        assertThrows(LottoException.class, () ->lottoInfoService.setMoney(input));
    }

}
