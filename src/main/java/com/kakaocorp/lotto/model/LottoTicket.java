package com.kakaocorp.lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final Set<Integer> numbers;

    public LottoTicket(Set<Integer> numbers) {
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

    LottoResult check(Set<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(winningNumbers);
        int matches = intersection.size();
        boolean bonus = !winningNumbers.contains(bonusNumber) && numbers.contains(bonusNumber);
        return LottoResult.get(matches, bonus);
    }

    public String toArrayString() {
        int[] array = numbers.stream()
                .mapToInt(n -> n)
                .sorted()
                .toArray();
        return Arrays.toString(array);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
