package lotto.domain;

import static lotto.domain.Lotto.LOTTO_NUMBER_SIZE;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private static final int NUMBER_OF_LOTTO_FOR_TEST = 1000;

    LottoMachine lottoMachine;

    @BeforeEach
    void initTest() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("생성된 로또 번호 중복 테스트")
    void purchaseLottoTickets3() {
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
    void purchaseLottoTickets2() {
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
    void purchaseLottoTickets() {
        List<Lotto> lottoTickets = lottoMachine.purchaseLottoTickets(NUMBER_OF_LOTTO_FOR_TEST);

        lottoTickets.forEach(lottoTicket -> lottoTicket.getLottoNumbers()
            .forEach(number -> assertDoesNotThrow(() -> validateRangeOfNumber(number))));
    }

    private void validateRangeOfNumber(int number) throws Exception {
        if (number < Lotto.LOTTO_NUMBER_START || number > Lotto.LOTTO_NUMBER_END) {
            throw new Exception("로또의 허용 숫자 범위 (1 ~ 45) 를 벗어났습니다.");
        }
    }
}
