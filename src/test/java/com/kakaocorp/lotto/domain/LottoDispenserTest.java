package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.validation.LessThanMinimumException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoDispenserTest {

    private static final long RANDOM_SEED = 1234L;
    private static final int PRICE = LottoTicket.PRICE;

    private LottoDispenser subject;

    @BeforeEach
    void setUp() {
        Random random = new Random(RANDOM_SEED);
        subject = new LottoDispenser(random);
    }

    @Test
    void purchase_countInt() {
        int count = 5;

        List<LottoTicket> result = subject.purchase(count * PRICE, List.of());

        assertEquals(count, result.size());
    }

    @Test
    void purchase_countFloat() {
        float count = 5.5f;

        List<LottoTicket> result = subject.purchase((int) (count * PRICE), List.of());

        assertEquals((int) Math.floor(count), result.size());
    }

    @Test
    void purchase_manual_preservesArgument() {
        int count = 5;
        List<LottoTicket> manualTickets = List.of(
                new LottoTicket(Set.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Set.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Set.of(1, 2, 3, 4, 5, 6))
        );

        List<LottoTicket> result = subject.purchase(count * PRICE, manualTickets);

        assertTrue(result.containsAll(manualTickets));
    }

    @Test
    void purchase_manual_count() {
        int count = 5;
        List<LottoTicket> manualTickets = List.of(
                new LottoTicket(Set.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Set.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Set.of(1, 2, 3, 4, 5, 6))
        );

        List<LottoTicket> result = subject.purchase(count * PRICE, manualTickets);

        assertEquals(count, result.size());
    }

    @Test
    void purchase_cannotAffordOne() {
        Executable body = () -> subject.purchase(PRICE - 1, List.of());

        assertThrowsExactly(LessThanMinimumException.class, body);
    }
}
