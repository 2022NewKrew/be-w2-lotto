package service;

import exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import repository.LottoInfoRepository;
import repository.LottoPaperRepository;
import repository.WinNumbersRepository;

import java.util.List;

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

    @DisplayName("로또 결과 잘 계산하는지")
    @Test
    void getLottoResult() throws LottoException {
        LottoInfoRepository lottoInfoRepository = LottoInfoRepository.getLottoInfoRepository();
        LottoPaperRepository lottoPaperRepository = LottoPaperRepository.getLottoPaperRepository();
        WinNumbersRepository winNumbersRepository = WinNumbersRepository.getWinNumbersRepository();

        LottoWinService lottoWinService = LottoWinService.getLottoWinService();

        lottoInfoRepository.insertMoney(13000);

        lottoPaperRepository.insert(List.of(1, 2, 3, 4, 5, 6));       // First
        lottoPaperRepository.insert(List.of(1, 2, 3, 4, 5, 7));       // Second
        lottoPaperRepository.insert(List.of(1, 2, 3, 4, 5, 45));      // Third
        lottoPaperRepository.insert(List.of(1, 2, 3, 4, 7, 45));      // Fourth
        lottoPaperRepository.insert(List.of(1, 2, 3, 4, 44, 45));     // Fourth
        lottoPaperRepository.insert(List.of(1, 2, 3, 7, 44, 45));     // Fifth
        lottoPaperRepository.insert(List.of(1, 2, 3, 43, 44, 45));    // Fifth
        lottoPaperRepository.insert(List.of(1, 2, 7, 43, 44, 45));
        lottoPaperRepository.insert(List.of(1, 2, 42, 43, 44, 45));
        lottoPaperRepository.insert(List.of(1, 7, 42, 43, 44, 45));
        lottoPaperRepository.insert(List.of(1, 41, 42, 43, 44, 45));
        lottoPaperRepository.insert(List.of(7, 41, 42, 43, 44, 45));
        lottoPaperRepository.insert(List.of(40, 41, 42, 43, 44, 45));

        winNumbersRepository.insert(List.of(1, 2, 3, 4, 5, 6));
        lottoWinService.setBonusNumber("7");

        String predict = "\n당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- 2개\n" +
                "4개 일치 (50000원)- 2개\n" +
                "5개 일치 (1500000원)- 1개\n" +
                "5개 일치, 보너스 볼 일치(30000000원)- 1개\n" +
                "6개 일치 (2000000000원)- 1개\n" +
                "총 수익률은 15627600%입니다.";

        assertEquals(predict, lottoWinService.getLottoResult().toString());
    }
}
