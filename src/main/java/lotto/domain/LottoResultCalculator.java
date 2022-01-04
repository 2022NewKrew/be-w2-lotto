package lotto.domain;

import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultCalculator {
    private final List<Integer> winningNumbers;

    public LottoResultCalculator(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Map<LottoRank, Integer> getLottoResultCounts(List<LottoTicket> tickets) {
        List<LottoRank> results = getLottoResults(tickets);
        Map<LottoRank, Integer> resultCounts = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            resultCounts.put(rank, (int) results.stream().filter(result -> result.equals(rank)).count());
        }
        return resultCounts;
    }

    private List<LottoRank> getLottoResults(List<LottoTicket> tickets) {
        return tickets.stream()
                .map(ticket -> LottoRank.parseResult(ticket.countEqualNumbers(winningNumbers)))
                .filter(ObjectUtils::isNotEmpty)
                .collect(Collectors.toList());
    }

    public int calculateEarningRate(Map<LottoRank, Integer> resultCounts, int totalAmount) {
        long sum = calculateSum(resultCounts);
        return (int) sum * 100 / totalAmount;
    }

    private long calculateSum(Map<LottoRank, Integer> resultCounts) {
        long sum = 0;
        for (LottoRank result : LottoRank.values()) {
            sum += (long) resultCounts.get(result) * result.getWinningMoney();
        }
        return sum;
    }
}
