package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private static final int NUMBER_OF_LOTTO_FOR_TEST = 1000;
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private static final List<Integer> VALID_NUMBERS = List.of(1, 2, 3, 4, 5, 45);
    private static final List<Integer> NOT_ENOUGH_NUMBERS = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> TOO_MANY_NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7);
    private static final List<Integer> DUPLICATE_NUMBERS = List.of(1, 2, 3, 4, 5, 5);
    private static final List<Integer> BELOW_LOWER_BOUND_NUMBERS = List.of(0, 1, 2, 3, 4, 5);
    private static final List<Integer> EXCEED_UPPER_BOUND_NUMBERS = List.of(1, 2, 3, 4, 5, 46);

    LottoMachine lottoMachine;

    @BeforeEach
    void initTest() {
        lottoMachine = LottoMachine.create();
    }

    @Test
    @DisplayName("생성된 로또 번호 중복 테스트")
    void purchaseLottoTicketTest() {
        List<Lotto> lottoTickets = lottoMachine.purchaseLottoTickets(NUMBER_OF_LOTTO_FOR_TEST);

        lottoTickets.forEach(lottoTicket ->
            assertDoesNotThrow(() -> validateNumberDuplicate(lottoTicket.getLottoNumbers())));
    }

    private void validateNumberDuplicate(List<Integer> numbers) throws Exception {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new Exception("로또의 번호는 중복될 수 없습니다.");
        }
    }

    @Test
    @DisplayName("생성된 로또 번호 개수 테스트")
    void purchaseLottoTicketTest2() {
        List<Lotto> lottoTickets = lottoMachine.purchaseLottoTickets(NUMBER_OF_LOTTO_FOR_TEST);

        lottoTickets.forEach(lottoTicket ->
            assertDoesNotThrow(() -> validateNumberSize(lottoTicket.getLottoNumbers())));
    }

    private void validateNumberSize(List<Integer> numbers) throws Exception {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new Exception("로또의 번호는 총 6개입니다.");
        }
    }

    @Test
    @DisplayName("생성된 로또 번호 테스트")
    void purchaseLottoTicketTest3() {
        List<Lotto> lottoTickets = lottoMachine.purchaseLottoTickets(NUMBER_OF_LOTTO_FOR_TEST);

        lottoTickets.forEach(lottoTicket -> lottoTicket.getLottoNumbers()
            .forEach(number -> assertDoesNotThrow(() -> validateRangeOfNumber(number))));
    }

    private void validateRangeOfNumber(int number) throws Exception {
        if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
            throw new Exception("로또의 허용 숫자 범위 (1 ~ 45) 를 벗어났습니다.");
        }
    }

    @Test
    @DisplayName("입력받은 로또 번호 검증 테스트")
    void generateLottoTicketWithNumbersTest() {
        assertDoesNotThrow(() -> lottoMachine.generateLottoTicketWithNumbers(VALID_NUMBERS));
    }

    @Test
    @DisplayName("입력받은 로또 번호 개수 검증 테스트")
    void generateLottoTicketWithNumbersTest2() {
        assertThrows(Exception.class, () -> lottoMachine.generateLottoTicketWithNumbers(
            NOT_ENOUGH_NUMBERS));
    }

    @Test
    @DisplayName("입력받은 로또 번호 개수 검증 테스트2")
    void generateLottoTicketWithNumbersTest3() {
        assertThrows(Exception.class, () -> lottoMachine.generateLottoTicketWithNumbers(
            TOO_MANY_NUMBERS));
    }

    @Test
    @DisplayName("입력받은 로또 번호 중복 검증 테스트")
    void generateLottoTicketWithNumbersTest4() {
        assertThrows(Exception.class,
            () -> lottoMachine.generateLottoTicketWithNumbers(DUPLICATE_NUMBERS));
    }

    @Test
    @DisplayName("입력받은 로또 번호 범위 검증 테스트")
    void generateLottoTicketWithNumbersTest5() {
        assertThrows(Exception.class,
            () -> lottoMachine.generateLottoTicketWithNumbers(BELOW_LOWER_BOUND_NUMBERS));
    }

    @Test
    @DisplayName("입력받은 로또 번호 범위 검증 테스트2")
    void generateLottoTicketWithNumbersTest6() {
        assertThrows(Exception.class,
            () -> lottoMachine.generateLottoTicketWithNumbers(EXCEED_UPPER_BOUND_NUMBERS));
    }
}
