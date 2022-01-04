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

    public int calculateMatchCount(WinningLottery winningLottery) {
        int matchCount = 0;
        for (Integer lotteryNumber : lotteryNumbers) {
            matchCount += winningLottery.contains(lotteryNumber);
        }
        return matchCount;
    }
}
