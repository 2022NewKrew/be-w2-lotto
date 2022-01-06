package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class LotteryNumbersTest {

    @Test
    @DisplayName("로또번호는 null일 수 없습니다.")
    void throwExceptionNumbersIsNull() {
        Throwable thrown = catchThrowable(() -> {
            new LotteryNumbers(null);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또번호는 null일 수 없습니다.");
    }

    @Test
    @DisplayName("로또번호는 6개 입니다.")
    void throwExceptionWhenExceedDefaultLength() {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (var number : Arrays.asList(9, 5, 8, 6, 7, 3, 1)) {
            lotteryNumbers.add(new LotteryNumber(number));
        }
        Throwable thrown = catchThrowable(() -> {
            new LotteryNumbers(new ArrayList<>());
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또번호는 6개 입니다.");
    }

    @Test
    @DisplayName("로또번호는 중복될 수 없습니다.")
    void throwExceptionWhenDuplicate() {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (var number : Arrays.asList(1, 3, 5, 21, 21, 36)) {
            lotteryNumbers.add(new LotteryNumber(number));
        }
        Throwable thrown = catchThrowable(() -> {
            new LotteryNumbers(lotteryNumbers);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("로또번호는 정렬 되어야 합니다.")
    void throwExceptionNoSorted() {
        List<LotteryNumber> testNumbers = new ArrayList<>();
        for (var number : Arrays.asList(9, 5, 8, 6, 7, 3)) {
            testNumbers.add(new LotteryNumber(number));
        }
        LotteryNumbers sortedNumbers = new LotteryNumbers(testNumbers);
        Collections.sort(testNumbers);

        assertThat(sortedNumbers)
                .isEqualTo(new LotteryNumbers(testNumbers));
    }
}