package domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketMachineTest {

    @Test
    @DisplayName("[성공] 생성된 로또에는 중복이 없어야 한다")
    void buySeveralLotto() {
        int purchaseAmount = 200000;
        int NumberOfLotteryNumbers = 6;
        LottoMachine lottoMachine = new LottoMachine();

        List<LottoTicket> lottoTicketListResult = lottoMachine.buyLottos(purchaseAmount);

        lottoTicketListResult.forEach((lotto) -> {
            Assertions.assertEquals(lotto.numbers().size(), NumberOfLotteryNumbers);
        });
    }
}