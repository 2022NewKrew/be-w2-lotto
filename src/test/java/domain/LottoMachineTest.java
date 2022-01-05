package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoMachineTest {

    @Test
    @DisplayName("[성공] 생성된 로또에는 중복이 없어야 한다")
    void buySeveralLotto() {
        int purchaseAmount = 20000;

        List<Lotto> lottoListResult = LottoMachine.buySeveralLotto(purchaseAmount);

        lottoListResult.forEach((lotto) -> {
            // FIXME - 원래 여기서 중복을 확인하려 했으나 lotto안의 numbers를 꺼내올 방법이 없네요
        });
    }
}