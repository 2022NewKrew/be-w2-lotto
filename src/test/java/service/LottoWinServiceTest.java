package service;

import exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinServiceTest {

    @DisplayName("범위 내에서 서로 다른 6개의 로또 번호 입력만 허용하는지")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 5",
            "1,2,3,4,5",
            "-1, 2, 3, 4, 5, 6",
            "1, 2, 3, 4, 5, 66"})
    @ParameterizedTest
    void isSixNumbers(String input) {
        LottoWinService lottoWinService = LottoWinService.getLottoWinService();

        assertThrows(LottoException.class, () -> lottoWinService.setWinNumbers(input));
    }

    @DisplayName("당첨 번호와 겹치치 않는 올바른 보너스 번호가 들어가는지")
    @Test
    void isUniqueBonusNumber() throws LottoException {
        LottoWinService lottoWinService = LottoWinService.getLottoWinService();
        String winNumbers = "1,2,3,4,5,6";
        String bonusNumber1 = "1";
        String bonusNumber2 = "100";
        lottoWinService.setWinNumbers(winNumbers);

        assertThrows(LottoException.class, () -> lottoWinService.setBonusNumber(bonusNumber1));
        assertThrows(LottoException.class, () -> lottoWinService.setBonusNumber(bonusNumber2));
    }
}
