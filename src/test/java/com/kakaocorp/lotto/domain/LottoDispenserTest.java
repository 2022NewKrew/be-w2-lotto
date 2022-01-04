package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.model.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoDispenserTest {

    private static final long RANDOM_SEED = 1234L;
    private static final int PRICE = 10;

    private LottoDispenser subject;

    @BeforeEach
    void setUp() {
        Random random = new Random(RANDOM_SEED);
        Rule rule = new Rule.Builder()
                .minNumber(1)
                .maxNumber(45)
                .numberCount(6)
                .price(PRICE)
                .random(random)
                .build();
        subject = new LottoDispenser(rule);
    }

    @Test
    void purchase_countInt() {
        int count = 5;

        List<LottoTicket> result = subject.purchase(count * PRICE);

        assertEquals(count, result.size());
    }

    @Test
    void purchase_countFloat() {
        float count = 5.5f;

        List<LottoTicket> result = subject.purchase((int) (count * PRICE));

        assertEquals(Math.floor(count), result.size());
    }
}
