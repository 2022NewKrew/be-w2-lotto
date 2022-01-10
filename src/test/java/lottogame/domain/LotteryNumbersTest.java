package lottogame.domain;

import lottogame.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LotteryNumbersTest {

    @Test
    @DisplayName("로또번호는 null일 수 없습니다.")
    void throwExceptionNumbersIsNull() {
        assertThatThrownBy(() -> {
            new LotteryNumbers(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.PRAMETER_IS_NULL.getErrorMessage());
    }

    @Test
    @DisplayName("로또번호는 6개 입니다.")
    void throwExceptionWhenExceedDefaultLength() {
        List<LotteryNumber> lotteryNumbers = Arrays.asList(9, 5, 8, 6, 7, 3, 1)
                .stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> {
            new LotteryNumbers(lotteryNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.NOT_MATCH_LOTTERY_NUMBERS_DEFAULT_LENGTH.getErrorMessage());
    }

    @Test
    @DisplayName("로또번호는 중복될 수 없습니다.")
    void throwExceptionWhenDuplicate() {
        List<LotteryNumber> lotteryNumbers = Arrays.asList(1, 3, 5, 21, 21, 36)
                .stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> {
            new LotteryNumbers(lotteryNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.DUPLICATE_LOTTERY_NUMBERS.getErrorMessage());
    }

    @Test
    @DisplayName("로또번호는 정렬 되어야 합니다.")
    void throwExceptionNoSorted() {
        List<LotteryNumber> lotteryNumbers = Arrays.asList(9, 5, 8, 6, 7, 3)
                .stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        LotteryNumbers sortedNumbers = new LotteryNumbers(lotteryNumbers);
        Collections.sort(lotteryNumbers);

        assertThat(sortedNumbers)
                .isEqualTo(new LotteryNumbers(lotteryNumbers));
    }

    @Test
    @DisplayName("일치하는 로또번호 개수 세기")
    void checkCountNumberOfMatch() {
        LotteryNumbers lotteryNumbers = new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList()));

        LotteryNumbers winningNumbers = new LotteryNumbers(Arrays.asList(3, 4, 5, 6, 7, 8)
                .stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList()));

        assertThat(lotteryNumbers.countNumberOfMatch(winningNumbers)).isEqualTo(4);
    }

    @Test
    @DisplayName("일치하는 번호가 있는지 확인하기")
    void checkIsContain() {
        LotteryNumbers lotteryNumbers = new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList()));
        LotteryNumber containNumber = new LotteryNumber(4);
        LotteryNumber noContainNumber = new LotteryNumber(7);

        assertThat(lotteryNumbers.isContain(containNumber)).isEqualTo(true);
        assertThat(lotteryNumbers.isContain(noContainNumber)).isEqualTo(false);
    }
}