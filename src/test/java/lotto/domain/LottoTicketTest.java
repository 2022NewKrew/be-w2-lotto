package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTicketTest {

    List<Integer> numbers;
    LottoTicket ticket;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = LottoNumbers.createByNumbers(numbers);
        ticket = new LottoTicket(lottoNumbers);
    }

    @DisplayName("로또 번호를 포함하고 있다면 true, 포함하고 있지 않다면 false를 반환해야 한다.")
    @Test
    void containLottoNumbers() {
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            LottoNumber lottoNumber = new LottoNumber(i);
            assertThat(ticket.containLottoNumber(lottoNumber)).isEqualTo(numbers.contains(i));
        }
    }

    @DisplayName("전달하는 로또 넘버들과 일치하는 개수 확인 테스트")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void countMatchNumberOfLottoNumbers(List<Integer> numbers, int expected) {
        LottoNumbers lottoNumbers = LottoNumbers.createByNumbers(numbers);
        assertThat(ticket.countMatchNumberOfLottoNumbers(lottoNumbers)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                arguments(List.of(1, 2, 3, 4, 5, 6), 6),
                arguments(List.of(1, 2, 3, 4, 5, 10), 5),
                arguments(List.of(1, 2, 3, 4, 10, 11), 4),
                arguments(List.of(1, 2, 3, 10, 11, 12), 3),
                arguments(List.of(1, 2, 10, 11, 12, 13), 2),
                arguments(List.of(1, 10, 11, 12, 13, 14), 1),
                arguments(List.of(10, 11, 12, 13, 14, 15), 0)
        );
    }

}