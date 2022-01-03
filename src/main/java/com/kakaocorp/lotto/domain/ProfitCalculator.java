package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoResult;

import java.util.Map;

public class ProfitCalculator {

    public float calculate(int payment, Map<LottoResult, Integer> results) {
        int totalGain = results.entrySet().stream().reduce(0, this::accumulate, Integer::sum);
        return ((float) totalGain) / payment;
    }

    private int accumulate(int totalGain, Map.Entry<LottoResult, Integer> entry) {
        LottoResult result = entry.getKey();
        int count = entry.getValue();
        return result.accumulate(totalGain, count);
    }
}
