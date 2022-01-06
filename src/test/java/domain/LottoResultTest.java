package domain;

import enums.Prize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

class LottoResultTest {
    static Set<Integer> winningNumbers;

    @BeforeAll
    static void setUp() {
        createWinningNumbers();
    }

    @Test
    @DisplayName("[성공] 일치하는 로또 번호를 올바르게 계산한다")
    void winningLottoCount() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(createLottoNumbers(8, 21, 23, 41, 42, 43));
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
        EnumMap<Prize, Integer> winningLottoCount_Answer = new EnumMap<>(Prize.class);
        winningLottoCount_Answer.put(Prize.THREE, 1);
        winningLottoCount_Answer.put(Prize.FOUR, 0);
        winningLottoCount_Answer.put(Prize.FIVE, 0);
        winningLottoCount_Answer.put(Prize.SIX, 0);
        LottoResult lottoResult = new LottoResult(winningNumbers);

        EnumMap<Prize, Integer> winningLottoCount = lottoResult.winningLottoCount(lottoList);

        winningLottoCount_Answer.forEach((key, value) -> {
            Assertions.assertEquals(winningLottoCount.get(key), value);
        });
    }

    @Test
    @DisplayName("[성공] 수익률을 올바르게 계산한다")
    void rateOfReturn() {
        long purchaseAmount = 14000;
        double rateOfReturn_Answer = (Prize.THREE.getMoney() - purchaseAmount) / (double)purchaseAmount * 100.0d;
        LottoResult lottoResult = new LottoResult(winningNumbers);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(createLottoNumbers(1, 2, 3, 10, 11, 12));

        double rateOfReturn = lottoResult.rateOfReturn(purchaseAmount, lottoList);

        Assertions.assertEquals(rateOfReturn, rateOfReturn_Answer);
    }

    Lotto createLottoNumbers(int n1, int n2, int n3, int n4, int n5, int n6) {
        Set<Integer> lottoNumbers = new HashSet<>();
        lottoNumbers.add(n1);
        lottoNumbers.add(n2);
        lottoNumbers.add(n3);
        lottoNumbers.add(n4);
        lottoNumbers.add(n5);
        lottoNumbers.add(n6);
        return new Lotto(lottoNumbers);
    }

    static void createWinningNumbers() {
        winningNumbers = new HashSet<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
    }
}