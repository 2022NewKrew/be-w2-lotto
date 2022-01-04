package step3.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchesTest {
    @DisplayName("수동으로 입력한 로또가 당첨됐을 때, 그 수익률을 확인")
    @Test
    void matchesCheckEarningRate() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        List<Lotto> manualLottos = List.of(lotto);
        Lottos lottos = new Lottos(manualLottos, 0);
        Result result = new Result("1, 2, 3, 4, 5, 6");
        BonusNumber bonusNumber = new BonusNumber(7, result);
        Matches matches = new Matches();

        matches.matchLottosWithResult(lottos, result, bonusNumber);

        assertEquals(200000000, matches.calcEarningsRate(lottos));
    }
}