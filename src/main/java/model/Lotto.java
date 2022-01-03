package model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {
    private static final Random random = new Random();
    private final List<Integer> lotto;

    public Lotto() {
        this.lotto = random
                .ints(1, 46)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    public int checkNumber(List<Integer> winningNumber) {
        return (int) winningNumber
                .stream()
                .filter(lotto::contains)
                .count();
    }
}
