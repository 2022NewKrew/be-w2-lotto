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

class WinningConditionTest {

    WinningCondition winningCondition;

    @BeforeEach
    void setup() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers winningLottoNumbers = LottoNumbers.createByNumbers(winningNumbers);
        LottoNumber bonusLottoNumber = new LottoNumber(7);
        winningCondition = new WinningCondition(winningLottoNumbers, bonusLottoNumber);
    }

    @DisplayName("로또 당첨 조건과 일치하는 로또 넘버 개수 확인 테스트")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void countEqualNumberOfLottoTicket(List<Integer> numbers, int expected) {
        LottoTicket ticket = new LottoTicket(LottoNumbers.createByNumbers(numbers));
        assertThat(winningCondition.countMatchNumberOfLottoTicket(ticket)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                arguments(List.of(10, 11, 12, 13, 14, 15), 0),
                arguments(List.of(1, 7, 8, 9, 10, 11), 1),
                arguments(List.of(1, 6, 20, 21, 22, 23), 2),
                arguments(List.of(2, 3, 5, 9, 10, 11), 3),
                arguments(List.of(1, 3, 4, 6, 44, 45), 4),
                arguments(List.of(2, 3, 4, 5, 6, 7), 5),
                arguments(List.of(1, 2, 3, 4, 5, 6), 6)
                );
    }

    @DisplayName("보너스 볼을 포함하고 있다면 true를 반환해야 한다.")
    @Test
    void containsBonusLottoNumberContainingBonusLottoNumber() {
        List<Integer> numbers = List.of(4, 5, 6, 7, 8, 9);
        LottoTicket ticket = new LottoTicket(LottoNumbers.createByNumbers(numbers));
        assertThat(winningCondition.containsBonusLottoNumber(ticket)).isTrue();
    }

    @DisplayName("보너스 볼을 포함하고 있다면 false를 반환해야 한다.")
    @Test
    void containsBonusLottoNumberNotContainingBonusLottoNumber() {
        List<Integer> numbers = List.of(40, 41, 42, 43, 44, 45);
        LottoTicket ticket = new LottoTicket(LottoNumbers.createByNumbers(numbers));
        assertThat(winningCondition.containsBonusLottoNumber(ticket)).isFalse();
    }

}