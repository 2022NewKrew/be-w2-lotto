package utility;

import domain.Lottery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryGeneratorTest {

    @DisplayName("정해진 갯수만큼 자동으로 로또를 생성해주는지 테스트")
    @Test
    void randomLotteriesGenerator() {
        // given
        int lotteryCount = 5;

        // when
        List<Lottery> lotteries = LotteryGenerator.randomLotteriesGenerator(lotteryCount);

        // then
        assertThat(lotteries.size()).isEqualTo(lotteryCount);
    }

}