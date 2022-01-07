package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.validation.IntRangeValidator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoDispenser {

    private final IntRangeValidator paymentValidator = IntRangeValidator.ofMinimum(LottoTicket.PRICE);
    private final Random random;

    public LottoDispenser(Random random) {
        this.random = random;
    }

    public List<LottoTicket> purchase(int payment, List<LottoTicket> manual) {
        paymentValidator.validate(payment);
        int price = LottoTicket.PRICE;
        int count = (payment - manual.size() * price) / price;
        List<LottoTicket> tickets = IntStream.range(0, count)
                .mapToObj(i -> random)
                .map(LottoTicket::from)
                .collect(Collectors.toList());
        tickets.addAll(manual);
        return tickets;
    }
}
