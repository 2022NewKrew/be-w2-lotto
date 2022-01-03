package com.kakaocorp.lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final Set<Integer> numbers;

    private LottoTicket(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoTicket from(Rule rule) {
        IntStream rng = rule.getRandom()
                .ints(rule.getMinNumber(), rule.getMaxNumber())
                .distinct()
                .limit(rule.getNumberCount());
        Set<Integer> numbers = rng.boxed().collect(Collectors.toSet());
        return new LottoTicket(numbers);
    }

    public LottoResult check(Set<Integer> winningNumbers) {
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(winningNumbers);
        int matches = intersection.size();
        return LottoResult.get(matches);
    }

    public String toArrayString() {
        int[] array = numbers.stream()
                .mapToInt(n -> n)
                .sorted()
                .toArray();
        return Arrays.toString(array);
    }
}
