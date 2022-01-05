package com.kakaocorp.lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoRecordTest {

    private LottoTicket ticket;

    @BeforeEach
    void setUp() {
        ticket = new LottoTicket(Set.of(17, 18, 22, 30, 31, 41));
    }

    @ParameterizedTest
    @MethodSource("provideCheckParameters")
    void check(Set<Integer> winningNumbers, int bonusNumber, LottoResult expected) {
        LottoRecord subject = new LottoRecord(winningNumbers, bonusNumber);

        LottoResult result = subject.check(ticket);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideCheckParameters() {
        return Stream.of(
                Arguments.of(Set.of(17, 18, 22, 30, 31, 41), 42, LottoResult.FIRST),
                Arguments.of(Set.of(17, 18, 22, 30, 31, 42), 41, LottoResult.SECOND),
                Arguments.of(Set.of(17, 18, 22, 30, 31, 42), 43, LottoResult.THIRD),
                Arguments.of(Set.of(18, 22, 30, 31, 42, 43), 43, LottoResult.FOURTH),
                Arguments.of(Set.of(18, 30, 31, 42, 43, 44), 45, LottoResult.FIFTH),
                Arguments.of(Set.of(30, 31, 42, 43, 44, 45), 45, LottoResult.LOSE),
                Arguments.of(Set.of(1, 31, 42, 43, 44, 45), 2, LottoResult.LOSE),
                Arguments.of(Set.of(1, 2, 42, 43, 44, 45), 2, LottoResult.LOSE)
        );
    }
}
