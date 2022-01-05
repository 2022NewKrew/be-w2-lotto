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

    public List<LottoTicket> purchase(int payment, List<LottoTicket> manual) {
        int price = rule.getPrice();
        int count = (payment - manual.size() * price) / price;
        List<LottoTicket> tickets = IntStream.range(0, count)
                .mapToObj(i -> rule)
                .map(LottoTicket::from)
                .collect(Collectors.toList());
        tickets.addAll(manual);
        return tickets;
    }
}
