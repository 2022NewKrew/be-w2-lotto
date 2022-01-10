package lottogame.domain;

import lottogame.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LotteryTicketTest {

    @Test
    @DisplayName("로또티켓 인자로 null을 사용할 수 없습니다.")
    void throwExceptionNumbersIsNull() {
        assertThatThrownBy(() -> {
            new LotteryTicket((LotteryNumbers) null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.PRAMETER_IS_NULL.getErrorMessage());
    }

    @Test
    @DisplayName("로또티켓 생성하기")
    void checkLotteryTicket() {
        new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또티켓 등수 매기기")
    void checkRankTicket() {
        LotteryTicket lotteryTicket = new LotteryTicket(new ManualGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).generate());
        LotteryTicket winningNumbers = new LotteryTicket(new ManualGenerator(Arrays.asList(3, 4, 5, 6, 7, 8)).generate());
        LotteryNumber bonusNumber = new LotteryNumber(1);

        assertThat(lotteryTicket.rankTicket(winningNumbers, bonusNumber)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("로또티켓에 포함된 번호인지 확인하기")
    void checkIsContain() {
        LotteryTicket ticketA = new LotteryTicket(new ManualGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).generate());
        LotteryTicket ticketB = new LotteryTicket(new ManualGenerator(Arrays.asList(2, 3, 4, 5, 6, 7)).generate());
        LotteryNumber bonusNumber = new LotteryNumber(1);

        assertThat(ticketA.isContain(bonusNumber)).isEqualTo(true);
        assertThat(ticketB.isContain(bonusNumber)).isEqualTo(false);
    }
}