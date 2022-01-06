package be.w2.lotto.domain.winningresult;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RewardsTest {

    @Test
    void stream_Rewards_객체의_values를_Stream으로_반환한다() {
        // given
        Class<Stream> expected = Stream.class;

        // when
        Stream<Rewards> actual = Rewards.stream();

        // then
        assertThat(actual).isInstanceOf(expected);
    }

    @Test
    void hasSameMatchedNumber_입력값에_해당하는_상수가_존재하면_true를_존재하지_않으면_false_반환한다() {
        // given
        int inputMatchedNumber = 3;
        List<Boolean> expected = List.of(true, false, false, false, false);

        // when
        List<Boolean> actual = Rewards.stream()
                .map(reward -> reward.hasSameMatchedNumber(inputMatchedNumber))
                .collect(Collectors.toList());

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getMatchedNumber_객체의_matchedNumber에_해당하는_값을_반환한다() {
        // given
        List<Integer> expected = List.of(3, 4, 5, 5, 6);

        // when
        List<Integer> actual = Rewards.stream()
                .map(Rewards::getMatchedNumber)
                .collect(Collectors.toList());

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void isBonus_객체의_isBonus에_해당하는_값을_반환한다() {
        // given
        List<Boolean> expected = List.of(false, false, false, true, false);

        // when
        List<Boolean> actual = Rewards.stream()
                .map(Rewards::isBonus)
                .collect(Collectors.toList());

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getReward_객체의_reward에_해당하는_값을_반환한다() {
        // given
        List<Integer> expected = List.of(5000, 50000, 1500000, 30000000, 2000000000);

        // when
        List<Integer> actual = Rewards.stream()
                .map(Rewards::getReward)
                .collect(Collectors.toList());

        // then
        assertThat(actual).isEqualTo(expected);
    }
}