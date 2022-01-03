package domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lottery {
    private final Set<Integer> lotteryNumbers;

    public Lottery(List<Integer> lotteryNumbers) {
        this.lotteryNumbers = Collections.unmodifiableSet(new LinkedHashSet<>(lotteryNumbers));
    }

    public void printLottery() {
        System.out.println(lotteryNumbers);
    }

    public int calculateMatchCount(WinningLottery winningLottery) {
        int matchCount = 0;
        for (Integer lotteryNumber : lotteryNumbers) {
            matchCount += winningLottery.contains(lotteryNumber);
        }
        return matchCount;
    }
}
