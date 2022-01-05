package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    @DisplayName("주문한 개수만큼 로또가 구매되어야 한다.")
    void test_CreateLottos_WhenCountIsGiven(int count) {
        // given

        // when
        Lottos lottos = Lottos.from(count);

        // then
        assertThat(lottos.getLottos()).hasSize(count);
    }

    @ParameterizedTest
    @MethodSource("getTestLotto")
    @DisplayName("구매한 로또들의 당첨 결과를 반환한다.")
    void test_MatchReward_WhenLottoListIsGiven(Item item) {
        // given
        List<Lotto> targetLottoList = getLottoList();
        targetLottoList.add(item.getLotto());
        Lottos lottos = new Lottos(targetLottoList);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoResult lottoResult = lottos.matchCounts(winningLotto);

        // then
        assertThat(lottoResult.get(item.getReward())).isEqualTo(item.getRewardCount());
    }

    private List<Lotto> getLottoList() {
        List<Lotto> targetLottoList = new ArrayList<>();
        targetLottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 16)));
        targetLottoList.add(new Lotto(List.of(1, 2, 13, 4, 15, 16)));
        targetLottoList.add(new Lotto(List.of(1, 12, 3, 4, 15, 16)));
        targetLottoList.add(new Lotto(List.of(1, 2, 3, 14, 5, 16)));
        targetLottoList.add(new Lotto(List.of(1, 2, 3, 14, 15, 6)));
        targetLottoList.add(new Lotto(List.of(1, 12, 13, 14, 15, 16)));
        return targetLottoList;
    }

    private static Stream<Item> getTestLotto() {
        return Stream.of(
            new Item(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Reward.FIRST, 1),
            new Item(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Reward.SECOND, 1),
            new Item(new Lotto(List.of(1, 2, 3, 4, 5, 16)), Reward.THIRD, 2),
            new Item(new Lotto(List.of(1, 2, 3, 4, 15, 16)), Reward.FOURTH, 3),
            new Item(new Lotto(List.of(1, 2, 3, 14, 15, 16)), Reward.FIFTH, 3)
        );
    }

    private static class Item {

        private final Lotto lotto;
        private final Reward reward;
        private final int rewardCount;

        public Item(Lotto lotto, Reward reward, int rewardCount) {
            this.lotto = lotto;
            this.reward = reward;
            this.rewardCount = rewardCount;
        }

        public Lotto getLotto() {
            return lotto;
        }

        public Reward getReward() {
            return reward;
        }

        public int getRewardCount() {
            return rewardCount;
        }
    }
}
