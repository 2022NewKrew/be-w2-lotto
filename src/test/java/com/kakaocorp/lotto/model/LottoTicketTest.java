package com.kakaocorp.lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    private LottoTicket subject;

    @BeforeEach
    void setUp() {
        subject = new LottoTicket(Set.of(17, 18, 22, 30, 31, 41));
    }

    @Test
    void from() {
        Random random = new Random(1234L);
        Rule rule = new Rule.Builder()
                .minNumber(1)
                .maxNumber(45)
                .numberCount(6)
                .random(random)
                .build();

        LottoTicket result = LottoTicket.from(rule);

        assertEquals(subject, result);
    }

    @Test
    void toArrayString() {
        String result = subject.toArrayString();

        assertEquals("[17, 18, 22, 30, 31, 41]", result);
    }
}
