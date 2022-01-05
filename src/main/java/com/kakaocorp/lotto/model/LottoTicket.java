package com.kakaocorp.lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    public static final int NUMBER_COUNT = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int PRICE = 1000;

    private final Set<Integer> numbers;

    public LottoTicket(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoTicket from(Random random) {
        IntStream rng = random.ints(MIN_NUMBER, MAX_NUMBER)
                .distinct()
                .limit(NUMBER_COUNT);
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

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
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
