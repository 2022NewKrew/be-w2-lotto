package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @Test
    void buyLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(14000);
        assertThat(lottoMachine.getLottos().size()).isEqualTo(14);
    }

    @Test
    void countLottoMatch() {
        List<Lotto> lottos = Arrays.asList(new Lotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B6)),
                new Lotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B7)),
                new Lotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B8)),
                new Lotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B7,LottoBall.B8)),
                new Lotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B7,LottoBall.B8,LottoBall.B9)),
                new Lotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B7,LottoBall.B8,LottoBall.B9,LottoBall.B10)),
                new Lotto(Arrays.asList(LottoBall.B1,LottoBall.B7,LottoBall.B8,LottoBall.B9,LottoBall.B10,LottoBall.B11)),
                new Lotto(Arrays.asList(LottoBall.B7,LottoBall.B8,LottoBall.B9,LottoBall.B10,LottoBall.B11,LottoBall.B12))
        );
        LottoMachine lottoMachine = new LottoMachine(lottos);
        List<Integer> result = lottoMachine.getLottoMatchResults(new WinningLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B6), LottoBall.B7));
        assertThat(result).isEqualTo(Arrays.asList(1,1,1,1,1));

    }
}