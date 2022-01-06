package lotto.domain.result;

import lotto.domain.LottoPrice;
import lotto.domain.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoConstant.NEWLINE;

public class LottoResult {

    private final Map<Rank, Integer> rankCounter;
    private int earningRate;

    public LottoResult(Map<Rank, Integer> rankCounter, int earningRate) {
        this.rankCounter = rankCounter;
        this.earningRate = earningRate;
    }

    public static LottoResult init() {
        int earningRate = 0;
        Map<Rank, Integer> rankCounter = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
        return new LottoResult(rankCounter, earningRate);
    }

    public LottoResult check(List<Ticket> ticketList, Ticket winningTicket, int bonusNumber) {
        double prizeAmount = 0;
        for (Ticket ticket : ticketList) {
            Rank rank = Rank.valueOf(ticket.countMatchingNumber(winningTicket), ticket.has(bonusNumber));
            int prevCount = rankCounter.get(rank);
            rankCounter.replace(rank, ++prevCount);
            prizeAmount += rank.getPrizeAmount();
        }
        int lottoPurchaseAmount = LottoPrice.calculateLottoPurchaseAmount(ticketList.size());
        earningRate = (int) Math.round((prizeAmount - lottoPurchaseAmount) / lottoPurchaseAmount * 100);
        return this;
    }

    public int getEarningRate() {
        return earningRate;
    }

    public String rankCounterToString() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : Rank.values()) {
            if (rank == Rank.FAILED) continue;
            sb.append(rank.toString()).append(rankCounter.get(rank)).append("개");
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}
