package lotto.domain;

import lotto.domain.issue.RandomIssuePolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("로또 뭉치에 로또가 잘 생성이 되는가")
    void addLotto() {
    }

    @Test
    @DisplayName("로또 뭉치를 문자열로 잘 변환하는가")
    void printLottos() {
    }

    @Test
    @DisplayName("로또 뭉치에 지불한 돈 만큼 로또가 구매되어 들어가는가")
    void size() {
        //given
        Lottos lottos = new Lottos();
        int purchaseAmount = 15000;
        lottos.addLotto(purchaseAmount, new RandomIssuePolicy());

        //when
        int size = lottos.size();

        //then
        assertThat(size).isEqualTo(purchaseAmount / LOTTO_PRICE);
    }

    @Test
    @DisplayName("로또 뭉치의 당첨결과를 확인했을 때 수익률을 잘 계산하는가")
    void getEarningRate() {
        //given
//        Lottos lottos = new Lottos();
//        int purchaseAmount = 15000;
//        lottos.addLotto(purchaseAmount, new RandomIssuePolicy());

        //when

        //then
    }

    @Test
    @DisplayName("로또 뭉치의 당첨 여부를 잘 확인하는가")
    void checkLottoList() {
    }
}