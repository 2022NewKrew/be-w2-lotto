package service;

import domain.lotto.Lotto;
import domain.lotto.LottoGameInfo;
import domain.lotto.LottoOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static util.LottoConst.LOTTO_PRICE;

class LottoGenerateServiceTest {

    private static final List<LottoOrder> EMPTY_MANUAL_LOTTO_ORDER = Collections.emptyList();
    private static final int MONEY = LOTTO_PRICE * 10;

    private final LottoGenerateService lottoGenerateService = new LottoGenerateService();

    @Test
    @DisplayName("로또 게임 정보를 통해 로또들을 무작위로 생성한다.")
    void createLottos() {
        //given
        LottoGameInfo lottoGameInfo = new LottoGameInfo(MONEY, EMPTY_MANUAL_LOTTO_ORDER);

        //when
        List<Lotto> lottos = lottoGenerateService.createLottos(lottoGameInfo);

        //then
        assertThat(lottos.size()).isEqualTo(MONEY / LOTTO_PRICE);
    }
}