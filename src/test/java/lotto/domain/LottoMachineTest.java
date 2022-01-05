package lotto.domain;

import lotto.domain.issue.IssuePolicy;
import lotto.domain.issue.RandomIssuePolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    @Test
    @DisplayName("로또 리스트를 잘 생성해 내는가")
    void purchaseLotto() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        int purchaseAmount = 15000;
        IssuePolicy issuePolicy = new RandomIssuePolicy();
        List<Lotto> lottoList = lottoMachine.purchaseLotto(purchaseAmount, issuePolicy);

        //when
        int size = lottoList.size();

        //then
        assertThat(size).isEqualTo(purchaseAmount / LOTTO_PRICE);
    }
}