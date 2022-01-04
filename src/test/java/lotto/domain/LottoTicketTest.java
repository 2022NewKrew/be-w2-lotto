package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @ParameterizedTest
    @MethodSource("provideLotteries")
    @DisplayName("당첨 번호와 일치하는 숫자 개수 확인 테스트")
    public void countEqualNumbers(List<Integer> numbers, int expectedEqualCount) {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 43));
        assertThat(lottoTicket.countEqualNumbers(numbers)).isEqualTo(expectedEqualCount);
    }

    private static Stream<Arguments> provideLotteries() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 43), 6),
                Arguments.arguments(List.of(1, 2, 30, 4, 5, 43), 5),
                Arguments.arguments(List.of(10, 2, 3, 4, 5, 45), 4),
                Arguments.arguments(List.of(10, 20, 3, 40, 5, 43), 3),
                Arguments.arguments(List.of(2, 10, 11, 12, 13, 43), 2),
                Arguments.arguments(List.of(40, 41, 42, 43, 44, 45), 1),
                Arguments.arguments(List.of(6, 7, 8, 9, 10, 44), 0)
        );
    }
}