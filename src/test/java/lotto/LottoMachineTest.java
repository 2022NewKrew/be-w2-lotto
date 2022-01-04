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
        List<Lotto> lottos = Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(1,2,3,4,5,7)),
                new Lotto(Arrays.asList(1,2,3,4,7,8)),
                new Lotto(Arrays.asList(1,2,3,7,8,9)),
                new Lotto(Arrays.asList(1,2,7,8,9,10)),
                new Lotto(Arrays.asList(1,7,8,9,10,11)),
                new Lotto(Arrays.asList(7,8,9,10,11,12))
        );
        LottoMachine lottoMachine = new LottoMachine(lottos);
        List<Integer> result = lottoMachine.countLottoMatch(new WinningLotto(Arrays.asList(1,2,3,4,5,6)));
        assertThat(result).isEqualTo(Arrays.asList(1,1,1,1,1,1,1));

    }
}