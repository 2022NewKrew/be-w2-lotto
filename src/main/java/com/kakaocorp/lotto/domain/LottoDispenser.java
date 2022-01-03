package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.model.Rule;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoDispenser {

    private final Rule rule;

    public LottoDispenser(Rule rule) {
        this.rule = rule;
    }

    public List<LottoTicket> purchase(int payment) {
        int count = getCount(payment);
        return IntStream.range(0, count)
                .mapToObj(i -> rule)
                .map(LottoTicket::from)
                .collect(Collectors.toList());
    }

    private int getCount(int payment) {
        return payment / rule.getPrice();
    }
}
