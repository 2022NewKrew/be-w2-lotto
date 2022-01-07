package domain;

import exceptions.InvalidLastWeekWinningNumber;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    static Set<Integer> winningNumbers;
    static int NUMBER_OF_LOTTERY_NUMBERS = 6;

    @BeforeAll
    static void setUp() {
        createWinningNumbers();
    }

    @Test
    @DisplayName("[성공] Lotto 객체를 생성한다")
    void Lotto() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        new Lotto(numbers);
    }

    @Test
    @DisplayName("[실패] 생성자에 null을 넣을 시 IllegalArgumentException을 던져야 한다")
    void Lotto_Failed_By_Null() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Lotto(null));
    }

    @Test
    @DisplayName("[실패] 로또 개수가 6개가 아닐 때 InvalidLastWeekWinningNumber를 던져야 한다")
    void Lotto_Failed_By_InvalidLottoNumberLength() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Assertions.assertThrows(InvalidLastWeekWinningNumber.class,
                () -> new Lotto(numbers));
    }

    @DisplayName("[실패] 범위를 벗어나는 숫자가 들어오면 InvalidLastWeekWinningNumber를 던져야 한다")
    @ParameterizedTest(name = "{0} 들어오는 경우")
    @ValueSource(ints = {0, 46, -1})
    void Lotto_Failed_By_(int invalidNumber) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(invalidNumber);

        Assertions.assertThrows(InvalidLastWeekWinningNumber.class,
                () -> new Lotto(numbers));
    }

    @DisplayName("[성공] checkMatchCount가 정상적으로 동작한다 ")
    @ParameterizedTest(name = "{6}개가 일치하는 경우")
    @CsvSource({"1, 2, 3, 4, 5, 6, 6", "1, 2, 3, 4, 5, 10, 5", "1, 2, 3, 4, 10, 11, 4", "1, 2, 3, 10, 11, 12, 3",
            "1, 2, 10, 11, 12, 13, 2", "1, 10, 11, 12, 13, 14, 1"})
    void checkMatchCount(int n1, int n2, int n3, int n4, int n5, int n6, int result) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(n1);
        numbers.add(n2);
        numbers.add(n3);
        numbers.add(n4);
        numbers.add(n5);
        numbers.add(n6);
        Lotto lotto = new Lotto(numbers);

        Assertions.assertEquals(lotto.matchCount(winningNumbers), result);
    }

    static void createWinningNumbers() {
        winningNumbers = new HashSet<>(NUMBER_OF_LOTTERY_NUMBERS);
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
    }
}