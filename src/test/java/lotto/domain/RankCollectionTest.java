package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankCollectionTest {

    @Test
    @DisplayName("당첨된 만큼의 로또를 반환하는지")
    void test1() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(7,8,9,10,11,12)));
        LottoCollection lottoCollection = new LottoCollection(lottos);

        assertThat(RankCollection.of(lottoCollection, winningLotto).getRankCollection().size()).isEqualTo(2);
    }
}