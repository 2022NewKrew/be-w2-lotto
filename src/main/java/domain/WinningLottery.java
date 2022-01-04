package domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottery {
    private final Set<Integer> drawnNumbers;
    private final int bonusNumber;

    public WinningLottery(Set<Integer> drawnNumber, int bonusNumber) {
        this.drawnNumbers = Collections.unmodifiableSet(drawnNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Rank> checkRank(List<Lottery> lotteries) {
        return lotteries.stream()
                .map(this::checkRank)
                .collect(Collectors.toList());
    }

    public Rank checkRank(Lottery lottery) {
        int matchCount = lottery.calculateMatchCount(this.drawnNumbers);
        boolean bonusMatched = lottery.contains(this.bonusNumber);
        return Rank.valueOf(matchCount, bonusMatched);
    }
}
