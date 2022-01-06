package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static util.LottoConst.LOTTO_PRICE;

class LottoGeneratorTest {

    private static final int MONEY = 10000;

    @Test
    @DisplayName("입력한 금액에 따라 최대 구입할 수 있는 로또의 개수 만큼 생성한다.")
    void generateAllLotto() {
        //given
        LottoGameInfo lottoGameInfo = new LottoGameInfo(MONEY);

        //when
        List<Lotto> result = LottoGenerator.generateLottos(lottoGameInfo.getAutomaticallyPurchaseQuantity());

        //then
        assertThat(result.size()).isEqualTo(MONEY / LOTTO_PRICE);
    }

    @Test
    @DisplayName("수동으로 로또 번호를 입력하여 하나의 로또를 생성한다")
    void generateOneLotto() {
        //given
        List<Integer> lottoInputSequence = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto result = LottoGenerator.generateOneLotto(lottoInputSequence);

        //then
        assertThat(result.toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("로또 문자열의 순서를 무작위로 섞어도 정렬된 로또를 생성한다")
    void generateOneLottoWithAscendingOrder() {
        //given
        List<Integer> lottoInputSequence = List.of(5, 6, 3, 1, 4, 2);

        //when
        Lotto result = LottoGenerator.generateOneLotto(lottoInputSequence);

        //then
        assertThat(result.toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

}