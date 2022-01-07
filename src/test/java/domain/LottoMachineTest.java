package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoMachineTest {

    @Test
    @DisplayName("[성공] 생성된 로또에는 중복이 없어야 한다")
    void buySeveralLotto() {
        int purchaseAmount = 200000;
        int NumberOfLotteryNumbers = 6;
        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> lottoListResult = lottoMachine.buyLottos(purchaseAmount);

        lottoListResult.forEach((lotto) -> {
            Assertions.assertEquals(lotto.numbers().size(), NumberOfLotteryNumbers);
        });
    }
}