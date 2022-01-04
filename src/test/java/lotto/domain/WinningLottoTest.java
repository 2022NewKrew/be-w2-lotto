package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("getTestLotto")
    @DisplayName("로또 번호를 넣으면 등수가 나온다.")
    void test_MatchReward_WithLotto(Item item) {
        // given
        Lotto lotto = item.getLotto();
        Reward reward = item.getReward();

        // when
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6));

        // then
        assertThat(winningLotto.matchResult(lotto)).isEqualTo(reward);
    }

    private static Stream<Item> getTestLotto() {
        return Stream.of(
            new Item(new Lotto(List.of(1,2,3,4,5,6)), Reward.FIRST),
            new Item(new Lotto(List.of(1,2,3,4,5,16)), Reward.SECOND),
            new Item(new Lotto(List.of(1,2,3,4,15,16)), Reward.THIRD),
            new Item(new Lotto(List.of(1,2,3,14,15,16)), Reward.FOURTH),
            new Item(new Lotto(List.of(1,2,13,14,15,16)), Reward.NONE)
        );
    }

    static class Item {

        private final Lotto lotto;

        private final Reward reward;
        public Item(Lotto lotto, Reward reward) {
            this.lotto = lotto;
            this.reward = reward;
        }

        public Lotto getLotto() {
            return lotto;
        }

        public Reward getReward() {
            return reward;
        }
    }
}