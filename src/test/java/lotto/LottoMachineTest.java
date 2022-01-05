package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void buyLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(14000);
        assertThat(lottoMachine.getAutomaticLottos().size()).isEqualTo(14);
    }

    @Test
    void countLottoMatch() {
        List<UserLotto> lottos = Arrays.asList(new UserLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B6)),
                new UserLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B7)),
                new UserLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B8)),
                new UserLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B7,LottoBall.B8)),
                new UserLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B7,LottoBall.B8,LottoBall.B9)),
                new UserLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B7,LottoBall.B8,LottoBall.B9,LottoBall.B10)),
                new UserLotto(Arrays.asList(LottoBall.B1,LottoBall.B7,LottoBall.B8,LottoBall.B9,LottoBall.B10,LottoBall.B11)),
                new UserLotto(Arrays.asList(LottoBall.B7,LottoBall.B8,LottoBall.B9,LottoBall.B10,LottoBall.B11,LottoBall.B12))
        );
        LottoMachine lottoMachine = new LottoMachine(lottos);
        RankCount rankCount = lottoMachine.getRankCount(new WinningLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B6), LottoBall.B7));
        assertThat(rankCount.getFirstCount()).isEqualTo(1);
        assertThat(rankCount.getSecondCount()).isEqualTo(1);
        assertThat(rankCount.getThirdCount()).isEqualTo(1);
        assertThat(rankCount.getFourthCount()).isEqualTo(1);
        assertThat(rankCount.getFifthCount()).isEqualTo(1);
    }
}