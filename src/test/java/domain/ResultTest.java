package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultTest {

    @Test
    void of_WinningListIsNull_ThrowsIllegalArgumentException() {
        long baseMoney = 5000;
        List<Lottery> lotteries = new ArrayList<>();
        assertThatIllegalArgumentException().isThrownBy(() -> Result.of(baseMoney, lotteries, null))
                .withMessage("당첨 복권 정보가 올바르지 않습니다.");
    }

    @Test
    void of_BaseMoneyIsZero_ThrowsIllegalArgumentException() {
        long baseMoney = 0;
        Set<Integer> winningLotteryNumber = IntStream.rangeClosed(1,6)
                .boxed()
                .collect(Collectors.toSet());
        List<Lottery> lotteries = new ArrayList<>();
        int bonusNumber = 7;
        WinningLottery winningLottery = new WinningLottery(winningLotteryNumber, bonusNumber);
        assertThatIllegalArgumentException().isThrownBy(() -> Result.of(baseMoney, lotteries, winningLottery))
                .withMessage("구입 금액 정보가 올바르지 않습니다.");
    }

    @Test
    void of_ValidParameters_ReturnsCorrectValue() {
        long baseMoney = 5000;
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
        int bonusNumber = 7;
        WinningLottery winningLottery = new WinningLottery(lotteryNumbers1, bonusNumber);

        Result result = Result.of(baseMoney, lotteries, winningLottery);

        assertThat(result.getCountOf(Rank.MISS)).isEqualTo(2);
        assertThat(result.getCountOf(Rank.FIFTH)).isEqualTo(0);
        assertThat(result.getCountOf(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.getCountOf(Rank.THIRD)).isEqualTo(0);
        assertThat(result.getCountOf(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getCountOf(Rank.FIRST)).isEqualTo(1);

        assertThat(result.getYieldPercent()).usingComparator(Double::compare)
                .isEqualTo(40600900);
    }
}
