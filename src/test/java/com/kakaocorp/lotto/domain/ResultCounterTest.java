package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoRecord;
import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.model.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

class ResultCounterTest {

    private static final long RANDOM_SEED = 777L;

    private ResultCounter subject;
    private Rule rule;

    @BeforeEach
    void setUp() {
        Random random = new Random(RANDOM_SEED);
        rule = new Rule.Builder()
                .minNumber(1)
                .maxNumber(45)
                .numberCount(6)
                .random(random)
                .build();
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
        inOrder.verify(consumer).accept(LottoResult.FIFTH, 2);
        inOrder.verify(consumer).accept(LottoResult.FIRST, 0);
        inOrder.verify(consumer).accept(LottoResult.FOURTH, 0);
        inOrder.verify(consumer).accept(LottoResult.LOSE, 8);
        inOrder.verify(consumer).accept(LottoResult.SECOND, 0);
        inOrder.verify(consumer).accept(LottoResult.THIRD, 0);
    }

    @Test
    void getTotalGain() {
        int count = 10;
        initialize(subject, count);

        int result = subject.getTotalGain();

        assertEquals(result, 10000);
    }

    private void initialize(ResultCounter counter, int count) {
        for (int i = 0; i < count; i++) {
            LottoTicket ticket = LottoTicket.from(rule);
            LottoRecord record = getRecord();
            counter.count(ticket, record);
        }
    }

    private LottoRecord getRecord() {
        Random random = rule.getRandom();
        int min = rule.getMinNumber();
        int max = rule.getMaxNumber();
        Set<Integer> winningNumbers = random
                .ints(min, max)
                .distinct()
                .limit(rule.getNumberCount())
                .boxed()
                .collect(Collectors.toSet());
        int bonusNumber = min + random.nextInt(max);
        return new LottoRecord(winningNumbers, bonusNumber);
    }
}
