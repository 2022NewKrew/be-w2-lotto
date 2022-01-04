package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLotteryTest {
    WinningLottery winningLottery;

    @BeforeEach
    void setUp() {
        Set<Integer> winningLotteryNumbers = IntStream.rangeClosed(1,6)
                .boxed()
                .collect(Collectors.toSet());
        int bonusNumber = 7;
        winningLottery = new WinningLottery(winningLotteryNumbers, bonusNumber);
    }

    @Test
    void checkRank_LotteryListIsNull_ThrowsIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> winningLottery.checkRank(null))
                .withMessage("로또 목록 정보가 올바르지 않습니다.");
    }

    @Test
    void checkRank_ValidParameter_ReturnsCorrectValue() {
        Set<Integer> lotteryNumbers1 = IntStream.rangeClosed(1,6)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> lotteryNumbers2 = IntStream.rangeClosed(2,7)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> lotteryNumbers3 = IntStream.rangeClosed(3,8)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> lotteryNumbers4 = IntStream.rangeClosed(5,10)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> lotteryNumbers5 = IntStream.rangeClosed(6,11)
                .boxed()
                .collect(Collectors.toSet());
        List<Lottery> lotteries = new ArrayList<>();
        lotteries.add(new Lottery(lotteryNumbers1));
        lotteries.add(new Lottery(lotteryNumbers2));
        lotteries.add(new Lottery(lotteryNumbers3));
        lotteries.add(new Lottery(lotteryNumbers4));
        lotteries.add(new Lottery(lotteryNumbers5));

        List<Rank> ranks = winningLottery.checkRank(lotteries);

        assertThat(ranks.size()).isEqualTo(5);
        assertThat(ranks.contains(Rank.MISS)).isTrue();
        assertThat(ranks.contains(Rank.FIFTH)).isFalse();
        assertThat(ranks.contains(Rank.FOURTH)).isTrue();
        assertThat(ranks.contains(Rank.THIRD)).isFalse();
        assertThat(ranks.contains(Rank.SECOND)).isTrue();
        assertThat(ranks.contains(Rank.FIRST)).isTrue();
    }
}
