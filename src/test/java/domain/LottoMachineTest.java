package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("[성공] 생성된 로또에는 중복이 없어야 한다")
    void buySeveralLotto() {
        int purchaseAmount = 200000;
        int NumberOfLotteryNumbers = 6;
        LottoMachine lottoMachine = new LottoMachine();
        List<Set<Integer>> manualNumbers = new ArrayList<>();

        LottoTickets lottoTicketListResult = lottoMachine.buyLottoTickets(purchaseAmount, manualNumbers);

        lottoTicketListResult.totalTickets().forEach((lotto) -> {
            Assertions.assertEquals(lotto.numbers().size(), NumberOfLotteryNumbers);
        });
    }
}