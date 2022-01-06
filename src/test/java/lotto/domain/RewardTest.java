package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RewardTest {

    @ParameterizedTest
    @MethodSource("getRewardSet")
    @DisplayName("맞춘 개수와 보너스 매치로 보상 객체를 가져온다.")
    void testReward(Reward expected) {
        // given

        // when
        Reward reward = Reward.of(expected.getMatchCount(), expected.getBonusMatch());

        // then
        assertThat(reward).isEqualTo(expected);
    }


    private static Stream<Reward> getRewardSet() {
        return Arrays.stream(Reward.values());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    @DisplayName("맞춘 개수가 0~6개가 아니라면 에러가 발생한다.")
    void testRewardWithBoundOver(int matchCount) {
        // given

        // when
        ThrowingCallable callable = () -> Reward.of(matchCount, false);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
