package com.kakaocorp.lotto.model;

import com.kakaocorp.lotto.validation.GreaterThanMaximumException;
import com.kakaocorp.lotto.validation.LessThanMinimumException;
import com.kakaocorp.lotto.validation.WrongSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class LottoTicketTest {

    private LottoTicket subject;

    @BeforeEach
    void setUp() {
        subject = new LottoTicket(Set.of(17, 18, 22, 30, 31, 41));
    }

    @ParameterizedTest
    @MethodSource("provideConstructorParameters")
    <T extends Throwable> void constructor(Set<Integer> numbers, Class<T> clazz) {
        Executable body = () -> new LottoTicket(numbers);

        assertThrowsExactly(clazz, body);
    }

    @Test
    void from() {
        Random random = new Random(1234L);

        LottoTicket result = LottoTicket.from(random);

        assertEquals(subject, result);
    }

    private static Stream<Arguments> provideConstructorParameters() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6, 7), WrongSizeException.class),
                Arguments.of(Set.of(1, 2, 3, 4, 5), WrongSizeException.class),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 46), GreaterThanMaximumException.class),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 0), LessThanMinimumException.class)
        );
    }
}
