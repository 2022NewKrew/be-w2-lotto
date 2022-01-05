package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

class LottoResultTest {
    static List<Integer> winningNumbers;
    static int NUMBER_OF_LOTTERY_NUMBERS = 6;

    @BeforeAll
    static void setUp() {
        createWinningNumbers();
    }

    @Test
    @DisplayName("[성공] 일치하는 로또 번호를 올바르게 계산한다")
    void winningLottoCount() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(createLottoNumbers(8, 21, 23, 41, 41, 43));
        lottoList.add(createLottoNumbers(3, 5, 11, 16, 32, 38));
        lottoList.add(createLottoNumbers(7, 11, 16, 35, 36, 44));
        lottoList.add(createLottoNumbers(1, 8, 11, 31, 41, 42));
        lottoList.add(createLottoNumbers(13, 14, 16, 38, 42, 45));
        lottoList.add(createLottoNumbers(7, 11, 30, 40, 42, 43));
        lottoList.add(createLottoNumbers(2, 13, 22, 32, 38, 45));
        lottoList.add(createLottoNumbers(23, 25, 33, 36, 39, 41));
        lottoList.add(createLottoNumbers(1, 3, 5, 14, 22, 45));
        lottoList.add(createLottoNumbers(5, 9, 38, 41, 43, 44));
        lottoList.add(createLottoNumbers(2, 8, 9, 18, 19, 21));
        lottoList.add(createLottoNumbers(13, 14, 18, 21, 23, 35));
        lottoList.add(createLottoNumbers(17, 21, 29, 37, 42, 45));
        lottoList.add(createLottoNumbers(3, 8, 27, 30, 35, 44));
        EnumMap<Prize, Integer> lottoResult_Answer = new EnumMap<>(Prize.class);
        lottoResult_Answer.put(Prize.FIFTH, 1);
        lottoResult_Answer.put(Prize.FOURTH, 0);
        lottoResult_Answer.put(Prize.THIRD, 0);
        lottoResult_Answer.put(Prize.FIRST, 0);

        EnumMap<Prize, Integer> lottoResult = LottoResult.winningLottoCount(winningNumbers, lottoList);
        
        lottoResult_Answer.forEach((key, value) -> {
            Assertions.assertEquals(lottoResult.get(key), value);
        });
    }

    @Test
    @DisplayName("[성공] 수익률을 올바르게 계산한다")
    void rateOfReturn() {
        int purchaseAmount = 14000;
        double rateOfReturn_Answer = -64.28;

        double rateOfReturn = LottoResult.rateOfReturn(winningNumbers, purchaseAmount);

        Assertions.assertEquals(rateOfReturn, rateOfReturn_Answer);
    }

    Lotto createLottoNumbers(int n1, int n2, int n3, int n4, int n5, int n6) {
        List<Integer> lottoNumbers = new ArrayList<>(NUMBER_OF_LOTTERY_NUMBERS);
        lottoNumbers.add(n1);
        lottoNumbers.add(n2);
        lottoNumbers.add(n3);
        lottoNumbers.add(n4);
        lottoNumbers.add(n5);
        lottoNumbers.add(n6);
        return new Lotto(lottoNumbers);
    }

    static void createWinningNumbers() {
        winningNumbers = new ArrayList<>(NUMBER_OF_LOTTERY_NUMBERS);
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
    }
}