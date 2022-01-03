package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultCounter {

    public Map<LottoResult, Integer> getResults(List<LottoTicket> tickets, List<Integer> winningNumbers) {
        Map<LottoResult, Integer> map = initialize();
        for (LottoTicket ticket : tickets) {
            LottoResult result = ticket.check(Set.copyOf(winningNumbers));
            increment(map, result);
        }
        return Map.copyOf(map);
    }

    private Map<LottoResult, Integer> initialize() {
        Map<LottoResult, Integer> map = new HashMap<>(LottoResult.values().length);
        for (LottoResult lottoResult : LottoResult.values()) {
            map.put(lottoResult, 0);
        }
        return map;
    }

    private void increment(Map<LottoResult, Integer> map, LottoResult result) {
        map.compute(result, (k, v) -> v == null ? 1 : v + 1);
    }
}
