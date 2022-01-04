package lotto.domain;

import lotto.exception.InvalidInputFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTicketFactoryTest {

    LottoTicketFactory factory = new LottoTicketFactoryImpl();

    @DisplayName("랜덤으로 생성한 로또 티켓의 숫자는 1부터 45 이외의 숫자를 포함하면 안된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createRandomLottoTicket(int number) {
        LottoTicket lottoTicket = factory.createRandomLottoTicket();
        assertThat(lottoTicket.containNumbers(number)).isFalse();
    }

    @DisplayName("전달 받은 숫자 만큼의 로또 티켓이 생성되야 한다.")
    @Test
    void createRandomLottoTickets() {
        int numOfTickets = 6;
        List<LottoTicket> lottoTickets = factory.createRandomLottoTickets(numOfTickets);
        assertThat(lottoTickets.size()).isEqualTo(numOfTickets);
    }

    @DisplayName("로또 티켓을 생성하기 위해 전달한 번호와 생성한 로또 티켓의 번호는 같아야 한다.")
    @Test
    void createLottoTicket() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket ticket = factory.createLottoTicket(numbers);
        assertThat(ticket.countEqualNumbers(numbers)).isEqualTo(numbers.size());
    }

    @DisplayName("로또 티켓을 생성할 때, 유효하지 않은 번호를 전달하면 에러가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void createLottoTicketContainingInvalidNumber(int invalidNumber) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        numbers.add(invalidNumber);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoTicket ticket = factory.createLottoTicket(numbers);
        });
    }

    @DisplayName("로또 티켓을 생성할 때, 숫자 리스트의 크기가 짧으면 에러가 발생한다.")
    @Test
    public void createLottoTicketByShortLengthOfNumbers() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoTicket ticket = factory.createLottoTicket(numbers);
        });
    }

    @DisplayName("로또 티켓을 생성할 때, 숫자 리스트의 크기가 길면 에러가 발생한다.")
    @Test
    public void createLottoTicketByLongLengthOfNumbers() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoTicket ticket = factory.createLottoTicket(numbers);
        });
    }

    @DisplayName("로또 티켓을 생성할 때, 숫자 리스트에 중복된 숫자를 포함하고 있으면 에러가 발생한다.")
    @Test
    public void createLottoTicketContainingDuplicatedNumbers() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoTicket ticket = factory.createLottoTicket(numbers);
        });
    }

}