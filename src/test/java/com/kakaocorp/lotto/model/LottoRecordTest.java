package com.kakaocorp.lotto.model;

import com.kakaocorp.lotto.validation.DuplicateNotAllowedException;
import com.kakaocorp.lotto.validation.GreaterThanMaximumException;
import com.kakaocorp.lotto.validation.LessThanMinimumException;
import com.kakaocorp.lotto.validation.WrongSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class LottoRecordTest {

    private LottoTicket ticket;

    @BeforeEach
    void setUp() {
        ticket = new LottoTicket(Set.of(17, 18, 22, 30, 31, 41));
    }

    @ParameterizedTest
    @MethodSource("provideConstructorParameters")
    <T extends Throwable> void constructor(Set<Integer> winningNumbers, int bonusNumber, Class<T> clazz) {
        Executable body = () -> new LottoRecord(winningNumbers, bonusNumber);

        assertThrowsExactly(clazz, body);
    }

    @ParameterizedTest
    @MethodSource("provideCheckParameters")
    void check(Set<Integer> winningNumbers, int bonusNumber, LottoResult expected) {
        LottoRecord subject = new LottoRecord(winningNumbers, bonusNumber);

        LottoResult result = subject.check(ticket);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideConstructorParameters() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), 6, DuplicateNotAllowedException.class),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6, 7), 45, WrongSizeException.class),
                Arguments.of(Set.of(1, 2, 3, 4, 5), 45, WrongSizeException.class),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), 0, LessThanMinimumException.class),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), 46, GreaterThanMaximumException.class),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 0), 45, LessThanMinimumException.class),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 46), 45, GreaterThanMaximumException.class)
        );
    }

    private static Stream<Arguments> provideCheckParameters() {
        return Stream.of(
                Arguments.of(Set.of(17, 18, 22, 30, 31, 41), 42, LottoResult.FIRST),
                Arguments.of(Set.of(17, 18, 22, 30, 31, 42), 41, LottoResult.SECOND),
                Arguments.of(Set.of(17, 18, 22, 30, 31, 42), 43, LottoResult.THIRD),
                Arguments.of(Set.of(18, 22, 30, 31, 42, 43), 44, LottoResult.FOURTH),
                Arguments.of(Set.of(18, 30, 31, 42, 43, 44), 45, LottoResult.FIFTH),
                Arguments.of(Set.of(30, 31, 42, 43, 44, 45), 40, LottoResult.LOSE),
                Arguments.of(Set.of(1, 31, 42, 43, 44, 45), 2, LottoResult.LOSE),
                Arguments.of(Set.of(1, 2, 42, 43, 44, 45), 3, LottoResult.LOSE)
        );
    }
}
