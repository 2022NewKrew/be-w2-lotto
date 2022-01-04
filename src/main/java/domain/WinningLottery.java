package domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottery {
    private final Set<Integer> drawnNumbers;

    public WinningLottery(Set<Integer> drawnNumber) {
        this.drawnNumbers = Collections.unmodifiableSet(drawnNumber);
    }

    public List<Rank> checkRank(List<Lottery> lotteries) {
        return lotteries.stream()
                .map(this::checkRank)
                .collect(Collectors.toList());
    }

    public Rank checkRank(Lottery lottery) {
        int matchCount = lottery.calculateMatchCount(this.drawnNumbers);
        return Rank.valueOf(matchCount);
    }
}
