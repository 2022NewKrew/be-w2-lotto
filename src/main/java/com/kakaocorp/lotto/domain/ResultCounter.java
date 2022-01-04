package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoRecord;
import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ResultCounter {

    private final Map<LottoResult, Integer> map = new HashMap<>(LottoResult.values().length);

    {
        for (LottoResult lottoResult : LottoResult.values()) {
            map.put(lottoResult, 0);
        }
    }

    public void count(LottoTicket ticket, LottoRecord record) {
        LottoResult result = record.check(ticket);
        increment(map, result);
    }

    public void forEachOrdered(Comparator<LottoResult> comparator, BiConsumer<LottoResult, Integer> consumer) {
        map.entrySet()
                .stream()
                .sorted((x, y) -> comparator.compare(x.getKey(), y.getKey()))
                .forEach(x -> consumer.accept(x.getKey(), x.getValue()));
    }

    public int getTotalGain() {
        return map.entrySet().stream().reduce(0, this::reduce, Integer::sum);
    }

    private int reduce(int acc, Map.Entry<LottoResult, Integer> x) {
        LottoResult result = x.getKey();
        int count = x.getValue();
        return acc + result.getValue(count);
    }

    private void increment(Map<LottoResult, Integer> map, LottoResult result) {
        map.compute(result, (k, v) -> v == null ? 1 : v + 1);
    }
}
