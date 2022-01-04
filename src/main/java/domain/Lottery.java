package domain;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {
    private final Set<Integer> lotteryNumbers;

    public Lottery(Set<Integer> lotteryNumbers) {
        this.lotteryNumbers = Collections.unmodifiableSet(new TreeSet<>(lotteryNumbers));
    }

    public Set<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public int calculateMatchCount(Set<Integer> drawnNumbers) {
        return (int) drawnNumbers.stream().filter(this::contains)
                .count();
    }

    public boolean contains(int number) {
        return lotteryNumbers.contains(number);
    }
}
