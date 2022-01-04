package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoRecord;
import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.model.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultCounterTest {

    private ResultCounter subject;

    @BeforeEach
    void setUp() {
        subject = new ResultCounter();
    }

    @Test
    void getResults() {
        List<LottoTicket> tickets = getTickets(1234L, 50000);
        Set<Integer> winningNumbers = Set.of(17, 18, 22, 30, 31, 41);
        int bonusNumber = 23;
        LottoRecord record = new LottoRecord(winningNumbers, bonusNumber);

        Map<LottoResult, Integer> result = subject.getResults(tickets, record);

        Map<LottoResult, Integer> expected = Map.of(
                LottoResult.FIRST, 1,
                LottoResult.SECOND, 0,
                LottoResult.THIRD, 5,
                LottoResult.FOURTH, 72,
                LottoResult.FIFTH, 1218,
                LottoResult.LOSE, 48704
        );
        assertEquals(expected, result);
    }

    @SuppressWarnings("SameParameterValue")
    private List<LottoTicket> getTickets(long randomSeed, int count) {
        Random random = new Random(randomSeed);
        Rule rule = new Rule.Builder()
                .minNumber(1)
                .maxNumber(45)
                .numberCount(6)
                .random(random)
                .build();
        return IntStream.range(0, count)
                .mapToObj(i -> LottoTicket.from(rule))
                .collect(Collectors.toList());
    }
}
