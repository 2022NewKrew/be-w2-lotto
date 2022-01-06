package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultCalculator {
    private final WinningCondition winningCondition;

    public LottoResultCalculator(WinningCondition winningCondition) {
        this.winningCondition = winningCondition;
    }

    public Map<LottoRank, Integer> getLottoResultCounts(List<LottoTicket> tickets) {
        List<LottoRank> results = getLottoResults(tickets);
        Map<LottoRank, Integer> resultCounts = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            int count = (int) results.stream().filter(result -> result.equals(rank)).count();
            resultCounts.put(rank, count);
        }
        return resultCounts;
    }

    private List<LottoRank> getLottoResults(List<LottoTicket> tickets) {
        return tickets.stream()
                .map(this::getLottoTicketResult)
                .collect(Collectors.toList());
    }

    private LottoRank getLottoTicketResult(LottoTicket ticket) {
        int numOfMatchCount = winningCondition.countMatchNumberOfLottoTicket(ticket);
        boolean isContainsBonusNumber = winningCondition.containsBonusLottoNumber(ticket);
        return LottoRank.parseResult(numOfMatchCount, isContainsBonusNumber);
    }

    public long calculateEarningRate(List<LottoTicket> tickets) {
        Map<LottoRank, Integer> resultCounts = getLottoResultCounts(tickets);
        int investment = resultCounts.values().stream().reduce(0, Integer::sum) * LottoTicket.PRICE;
        long earning = calculateSum(resultCounts);
        return (earning - investment) * 100 / investment;
    }

    private long calculateSum(Map<LottoRank, Integer> resultCounts) {
        return resultCounts.keySet().stream()
                .map(result -> (long) resultCounts.get(result) * result.getWinningMoney())
                .reduce(0L, Long::sum);
    }

}
