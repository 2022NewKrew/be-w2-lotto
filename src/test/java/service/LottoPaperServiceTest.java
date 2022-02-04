package service;

import exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoPaperServiceTest {

    @DisplayName("범위 내에서 서로 다른 6개의 로또 번호 입력만 허용하는 지")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 5",
            "1,2,3,4,5",
            "-1, 2, 3, 4, 5, 6",
            "1, 2, 3, 4, 5, 66"})
    @ParameterizedTest
    void isSixNumbers(String input) {
        LottoPaperService lottoPaperService = LottoPaperService.getLottoPaperService();

        List<String> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(input);

        assertThrows(LottoException.class, () -> lottoPaperService.setLottoNumbers(lottoNumbers));
    }
}
