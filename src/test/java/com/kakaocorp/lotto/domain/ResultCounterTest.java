package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoRecord;
import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

class ResultCounterTest {

    private static final long RANDOM_SEED = 777L;

    private ResultCounter subject;

    @BeforeEach
    void setUp() {
        subject = new ResultCounter();
    }

    @Test
    void forEachOrdered() {
        int count = 10;
        initialize(subject, count);
        Comparator<LottoResult> comparator = Comparator.comparing(Enum::name);

        @SuppressWarnings("unchecked")
        BiConsumer<LottoResult, Integer> consumer = mock(BiConsumer.class);
        subject.forEachOrdered(comparator, consumer);

        InOrder inOrder = inOrder(consumer);
        inOrder.verify(consumer).accept(LottoResult.FIFTH, 1);
        inOrder.verify(consumer).accept(LottoResult.FIRST, 1);
        inOrder.verify(consumer).accept(LottoResult.FOURTH, 1);
        inOrder.verify(consumer).accept(LottoResult.LOSE, 6);
        inOrder.verify(consumer).accept(LottoResult.SECOND, 1);
        inOrder.verify(consumer).accept(LottoResult.THIRD, 0);
    }

    @Test
    void getTotalGain() {
        int count = 10;
        initialize(subject, count);

        int result = subject.getTotalGain();

        assertEquals(result, 2030055000);
    }

    private void initialize(ResultCounter counter, int count) {
        for (int i = 0; i < count; i++) {
            int j = i * 2;
            LottoTicket ticket = new LottoTicket(Set.of(i, i + 1, i + 2, i + 3, i + 4, i + 5));
            LottoRecord record = new LottoRecord(Set.of(j, j + 1, j + 2, j + 3, j + 4, j + 5), j - 1);
            counter.count(ticket, record);
        }
    }
}
