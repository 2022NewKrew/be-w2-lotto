package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinningLottery {
    private final Set<Integer> drawnNumbers;

    public WinningLottery(List<Integer> drawnNumber) {
        this.drawnNumbers = Set.copyOf(drawnNumber);
    }

    public List<Rank> checkRank(List<Lottery> lotteries) {
        List<Rank> ranks = new ArrayList<>();
        for (Lottery lottery : lotteries) {
            ranks.add(this.checkRank(lottery));
        }
        return ranks;
    }

    public Rank checkRank(Lottery lottery) {
        int matchCount = 0;
        matchCount = lottery.calculateMatchCount(this);
        return Rank.valueOf(matchCount);
    }

    public int contains(Integer lotteryNumber) {
        if (drawnNumbers.contains(lotteryNumber)) {
            return 1;
        }
        else return 0;
    }
}
