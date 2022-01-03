package domain.entity;

import domain.model.LottoWinningType;
import domain.model.WinningResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoTicket getLottoTicket(int index) {
        return lottoTickets.get(index);
    }

    public int getSize() {
        return lottoTickets.size();
    }

    public WinningResult getMatchingCountAndProfit(LottoTicket winningTicket) {
        Map<Integer, Integer> countMap = collectCountMapByNumberOfWinning(winningTicket);
        int profit = calculateProfit(countMap);
        return new WinningResult(countMap, profit);
    }

    private Map<Integer, Integer> collectCountMapByNumberOfWinning(LottoTicket winningTicket) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(LottoTicket lottoTicket : lottoTickets) {
            int winningCount = lottoTicket.countWinningNumber(winningTicket);
            countMap.put(winningCount, countMap.getOrDefault(winningCount, 0) + 1);
        }
        return countMap;
    }

    private int calculateProfit(Map<Integer, Integer> countMap) {
        return countMap.entrySet().stream()
                .mapToInt((entry) -> entry.getValue() * LottoWinningType.getWinningsWinningCount(entry.getKey()).getWinnings())
                .sum();
    }
}
