package lottogame.domain;

import java.util.HashMap;
import java.util.List;

public class LotteryTickets {
    private List<LotteryTicket> lotteryTickets;

    LotteryTickets(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public List<LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }

    public Statistics makeStatistics(LotteryNumbers winningNumbers, LotteryNumber bonusNumber) {
        HashMap<Rank, Integer> statistics = new HashMap<>();
        for (var rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (var lotteryTicket : lotteryTickets) {
            Rank rank = lotteryTicket.rankTicket(winningNumbers, bonusNumber);
            statistics.computeIfPresent(rank, (key, value) -> value + 1);
        }
        return new Statistics(statistics);
    }
}
