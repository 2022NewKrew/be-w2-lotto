package com.kakaocorp.lotto.ui.controller;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.ui.view.LottoTicketPartView;
import com.kakaocorp.lotto.validation.GreaterThanMaximumException;
import com.kakaocorp.lotto.validation.LessThanMinimumException;
import com.kakaocorp.lotto.validation.WrongSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TicketPartTest {

    private LottoDispenser dispenser;

    @BeforeEach
    void setUp() {
        dispenser = new LottoDispenser(new Random());
    }

    @Test
    void handle() {
        int count = 16;
        LottoTicket ticket = new LottoTicket(Set.of(1, 2, 3, 4, 5, 6));
        LottoTicketPartView view = new StubView(
                () -> 1,
                () -> List.copyOf(ticket.getNumbers())
        );
        LottoTicketPart subject = new LottoTicketPart(view, dispenser);

        List<LottoTicket> tickets = subject.handle(count * LottoTicket.PRICE);

        assertEquals(count, tickets.size());
    }

    @ParameterizedTest
    @MethodSource("provideHandleWrongParameters")
    <T extends Throwable> void handle_wrong(Set<Integer> invalid, Class<T> clazz) {
        List<Set<Integer>> tickets = List.of(
                invalid,
                Set.of(1, 2, 3, 4, 5, 6)
        );
        int count = 10;
        AtomicInteger calls = new AtomicInteger(0);
        StubView view = StubView.spy(
                () -> count,
                () -> List.copyOf(tickets.get(Math.min(tickets.size() - 1, calls.getAndIncrement())))
        );
        LottoTicketPart subject = new LottoTicketPart(view, dispenser);

        List<LottoTicket> result = subject.handle(count * LottoTicket.PRICE);

        verify(view, times(count + 1)).acceptManualTicketInput();
        assertEquals(count, result.size());
    }

    private static Stream<Arguments> provideHandleWrongParameters() {
        return Stream.of(
                Arguments.of(
                        Set.of(1, 2, 3, 4, 5, 46),
                        GreaterThanMaximumException.class
                ),
                Arguments.of(
                        Set.of(1, 2, 3, 4, 5, 0),
                        LessThanMinimumException.class
                ),
                Arguments.of(
                        Set.of(1, 2, 3, 4, 5),
                        WrongSizeException.class
                ),
                Arguments.of(
                        Set.of(1, 2, 3, 4, 5, 6, 7),
                        WrongSizeException.class
                )
        );
    }

    private static class StubView implements LottoTicketPartView {

        private final IntSupplier countSupplier;
        private final Supplier<List<Integer>> ticketSupplier;

        public static StubView spy(IntSupplier countSupplier, Supplier<List<Integer>> ticketSupplier) {
            StubView original = new StubView(countSupplier, ticketSupplier);
            return Mockito.spy(original);
        }

        private StubView(IntSupplier countSupplier, Supplier<List<Integer>> ticketSupplier) {
            this.countSupplier = countSupplier;
            this.ticketSupplier = ticketSupplier;
        }

        @Override
        public void printLessThanMinimum(int minimum) {}
        @Override
        public void printGreaterThanMaximum(int maximum) {}
        @Override
        public void printDuplicateNotAllowed() {}
        @Override
        public void printValueNotAllowed(int value) {}
        @Override
        public void printWrongSize(int expected) {}
        @Override
        public void printNumberFormatError() {}
        @Override
        public void printTicket(LottoTicket ticket) {}
        @Override
        public void showManualTicketPromptHeader() {}
        @Override
        public void printTicketHeader(int size) {}

        @Override
        public int showManualCountPrompt() {
            return countSupplier.getAsInt();
        }

        @Override
        public List<Integer> acceptManualTicketInput() {
            return ticketSupplier.get();
        }
    }
}
