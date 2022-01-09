package domain;

import exceptions.InvalidLastWeekWinningNumber;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

    static Set<LottoNumber> winningNumbers;

    @BeforeAll
    static void setUp() {
        createWinningNumbers();
    }

    @Test
    @DisplayName("[성공] Lotto 객체를 생성한다")
    void Lotto() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);

        new LottoTicket(numbers);
    }

    @Test
    @DisplayName("[실패] 생성자에 null을 넣을 시 IllegalArgumentException을 던져야 한다")
    void Lotto_Failed_By_Null() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new LottoTicket(null));
    }

    @Test
    @DisplayName("[실패] 로또 개수가 6개가 아닐 때 InvalidLastWeekWinningNumber를 던져야 한다")
    void Lotto_Failed_By_InvalidLottoNumberLength() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);

        Assertions.assertThrows(InvalidLastWeekWinningNumber.class,
                () -> new LottoTicket(numbers));
    }

    @DisplayName("[성공] checkMatchCount가 정상적으로 동작한다 ")
    @ParameterizedTest(name = "{6}개가 일치하는 경우")
    @CsvSource({"1, 2, 3, 4, 5, 6, 6", "1, 2, 3, 4, 5, 10, 5", "1, 2, 3, 4, 10, 11, 4", "1, 2, 3, 10, 11, 12, 3",
            "1, 2, 10, 11, 12, 13, 2", "1, 10, 11, 12, 13, 14, 1"})
    void checkMatchCount(int n1, int n2, int n3, int n4, int n5, int n6, int result) {
        Set<Integer> numbers = Set.of(n1, n2, n3, n4, n5, n6);
        LottoTicket lottoTicket = new LottoTicket(numbers);

        Assertions.assertEquals(result, lottoTicket.matchCount(winningNumbers));
    }

    static void createWinningNumbers() {
        winningNumbers = Set.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                LottoNumber.from(5), LottoNumber.from(6));
    }
}