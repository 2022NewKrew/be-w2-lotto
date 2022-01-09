package domain;

import enums.Prize;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    static Set<Integer> winningNumbers;

    @BeforeAll
    static void setUp() {
        createWinningNumbers();
    }

    @Test
    @DisplayName("[성공] 일치하는 로또 번호를 올바르게 계산한다")
    void winningLottoCount() {
        List<Lotto> lottoList = List.of(createLottoNumbers(1, 2, 10, 11, 12, 13),
                createLottoNumbers(1, 2, 3, 10, 11, 12),
                createLottoNumbers(1, 2, 3, 4, 10, 11),
                createLottoNumbers(1, 2, 3, 4, 10, 7),
                createLottoNumbers(1, 2, 3, 4, 5, 10),
                createLottoNumbers(1, 2, 3, 4, 5, 7),
                createLottoNumbers(1, 2, 3, 4, 5, 6));
        EnumMap<Prize, Integer> winningLottoCount_Answer = new EnumMap<>(Prize.class);
        winningLottoCount_Answer.put(Prize.MISS, 1);
        winningLottoCount_Answer.put(Prize.THREE, 1);
        winningLottoCount_Answer.put(Prize.FOUR, 2);
        winningLottoCount_Answer.put(Prize.FIVE, 1);
        winningLottoCount_Answer.put(Prize.BONUS, 1);
        winningLottoCount_Answer.put(Prize.SIX, 1);
        int bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);

        EnumMap<Prize, Integer> winningLottoCount = lottoResult.winningLottoCount(lottoList);

        winningLottoCount_Answer.forEach((key, value) -> {
            Assertions.assertEquals(value, winningLottoCount.get(key));
        });
    }

    @Test
    @DisplayName("[성공] 수익률을 올바르게 계산한다")
    void rateOfReturn() {
        long purchaseAmount = 14000;
        double rateOfReturn_Answer = -64.28571428571429;
        int bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);
        List<Lotto> lottoList = List.of(createLottoNumbers(1, 2, 3, 10, 11, 12));

        double rateOfReturn = lottoResult.rateOfReturn(purchaseAmount, lottoList);

        Assertions.assertEquals(rateOfReturn, rateOfReturn_Answer);
    }

    Lotto createLottoNumbers(int n1, int n2, int n3, int n4, int n5, int n6) {
        Set<Integer> lottoNumbers = Set.of(n1, n2, n3, n4, n5, n6);

        return new Lotto(lottoNumbers);
    }

    static void createWinningNumbers() {
        winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
    }
}