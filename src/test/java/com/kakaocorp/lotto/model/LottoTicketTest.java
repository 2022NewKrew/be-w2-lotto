package com.kakaocorp.lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

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

    @Test
    void toArrayString() {
        String result = subject.toArrayString();

        assertEquals("[17, 18, 22, 30, 31, 41]", result);
    }
}
