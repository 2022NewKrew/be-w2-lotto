package com.kakaocorp.lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    private static final long RANDOM_SEED = 1234L;

    private LottoTicket subject;

    @BeforeEach
    void setUp() {
        Random random = new Random(RANDOM_SEED);
        Rule rule = new Rule.Builder()
                .minNumber(1)
                .maxNumber(45)
                .numberCount(6)
                .random(random)
                .build();
        subject = LottoTicket.from(rule);
    }

    @ParameterizedTest
    @MethodSource("provideCheckParameters")
    void check(Set<Integer> winningNumbers, LottoResult expected) {
        LottoResult result = subject.check(winningNumbers);

        assertEquals(expected, result);
    }

    @Test
    void toArrayString() {
        String result = subject.toArrayString();

        assertEquals("[17, 18, 22, 30, 31, 41]", result);
    }

    private static Stream<Arguments> provideCheckParameters() {
        return Stream.of(
                Arguments.of(Set.of(17, 18, 22, 30, 31, 41), LottoResult.FIRST),
                Arguments.of(Set.of(17, 18, 22, 30, 31, 42), LottoResult.SECOND),
                Arguments.of(Set.of(18, 22, 30, 31, 42, 43), LottoResult.THIRD),
                Arguments.of(Set.of(18, 30, 31, 42, 43, 44), LottoResult.FOURTH),
                Arguments.of(Set.of(30, 31, 42, 43, 44, 45), LottoResult.LOSE),
                Arguments.of(Set.of(1, 31, 42, 43, 44, 45), LottoResult.LOSE),
                Arguments.of(Set.of(1, 2, 42, 43, 44, 45), LottoResult.LOSE)
        );
    }
}
