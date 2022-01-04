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
        if (drawnNumbers == null || drawnNumbers.size() != lotteryNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호 목록 정보가 올바르지 않습니다.");
        }

        return (int) drawnNumbers.stream().filter(this::contains)
                .count();
    }

    public boolean contains(int number) {
        return lotteryNumbers.contains(number);
    }
}
