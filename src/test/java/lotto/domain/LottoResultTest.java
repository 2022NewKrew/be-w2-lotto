package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @Test
    @DisplayName("당첨결과에 따른 총 당첨금액을 반환한다.")
    void test_TotalReward() {
        // given
        final Map<Reward, Integer> rewardCounter = getRewardCounter();
        final LottoResult lottoResult = new LottoResult(rewardCounter);

        // when
        final BigDecimal totalReward = lottoResult.totalReward();

        // then
        assertThat(totalReward).isEqualTo(BigDecimal.valueOf(2_003_200_000));
    }

    @ParameterizedTest
    @MethodSource("getReward")
    @DisplayName("Reward의 당첨 횟수를 반환한다.")
    void test_GetRewardCount_WithReward(Item item) {
        // given
        final Map<Reward, Integer> rewardCounter = getRewardCounter();
        final LottoResult lottoResult = new LottoResult(rewardCounter);

        // when
        final int rewardCount = lottoResult.get(item.reward);

        // then
        assertThat(rewardCount).isEqualTo(item.count);
    }

    private Map<Reward, Integer> getRewardCounter() {
        final Map<Reward, Integer> rewardCounter = new EnumMap<>(Reward.class);
        rewardCounter.put(Reward.FIRST, 1);
        rewardCounter.put(Reward.THIRD, 2);
        rewardCounter.put(Reward.FOURTH, 4);
        return rewardCounter;
    }

    private static Stream<Item> getReward() {
        return Stream.of(
            new Item(Reward.FIRST, 1),
            new Item(Reward.SECOND, 0),
            new Item(Reward.THIRD, 2),
            new Item(Reward.FOURTH, 4)
        );
    }

    private static class Item {

        private final Reward reward;
        private final int count;

        public Item(Reward reward, int count) {
            this.reward = reward;
            this.count = count;
        }
    }
}
