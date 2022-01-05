package output;

import lotto.LottoConfig;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultChecker {
    public static Map<Integer, Integer> getResults(List<LottoTicket> lottoTickets) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        lottoTickets.stream().forEach(ticket -> resultMap.put(ticket.getResult().getScore(), resultMap.getOrDefault(ticket.getResult().getScore(),0) + 1));
        return resultMap;
    }

    public static double calculateProfitRate(int purchaseFee, Map<Integer, Integer> results) {
        Integer profit = calculateProfit(results);
        return Math.round(((double)profit / purchaseFee) * 100 - 100);
    }

    private static Integer calculateProfit(Map<Integer, Integer> results) {
        return IntStream.rangeClosed(LottoConfig.MIN_PRIZE_KEY, LottoConfig.MAX_PRIZE_KEY)
                .map(i -> results.getOrDefault(i, 0) * LottoResult.getResult(i).getPrize())
                .reduce((acc, a) -> acc + a).orElse(0);
    }
}
