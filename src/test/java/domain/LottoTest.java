package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

class LottoTest {
    static List<Integer> winningNumbers;
    static int NUMBER_OF_LOTTERY_NUMBERS = 6;

    @BeforeAll
    static void setUp() {
        createWinningNumbers();
    }

    @Test
    @DisplayName("[실패] 생성자에 null을 넣을 시 IllegalArgumentException을 던져야 한다")
    void Lotto_Failed() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Lotto(null));
    }

    @DisplayName("[성공] checkMatchCount가 정상적으로 동작한다 ")
    @ParameterizedTest(name = "{6}개가 일치하는 경우")
    @CsvSource({"1, 2, 3, 4, 5, 6, 6", "1, 2, 3, 4, 5, 10, 5", "1, 2, 3, 4, 10, 10, 4", "1, 2, 3, 10, 10, 10, 3", "1, 2, 10, 10, 10, 10, 2", "1, 10, 10, 10, 10, 10, 1"})
    void checkMatchCount(int n1, int n2, int n3, int n4, int n5, int n6, int result) {
        List<Integer> numbers = new ArrayList<>(NUMBER_OF_LOTTERY_NUMBERS);
        numbers.add(n1);
        numbers.add(n2);
        numbers.add(n3);
        numbers.add(n4);
        numbers.add(n5);
        numbers.add(n6);
        Lotto lotto = new Lotto(numbers);

        Assertions.assertEquals(lotto.checkMatchCount(winningNumbers), result);
    }

    static void createWinningNumbers() {
        winningNumbers = new ArrayList<>(NUMBER_OF_LOTTERY_NUMBERS);
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
    }
}