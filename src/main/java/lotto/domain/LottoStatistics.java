package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoResult, Integer> resultMap;
    private final long revenueRate;

    private LottoStatistics(Map<LottoResult, Integer> resultMap, long revenueRate) {
        this.resultMap = resultMap;
        this.revenueRate = revenueRate;
    }

    public static LottoStatistics of(WinningNumbers winningNumbers, LottoTickets lottoTickets, Money inputMoney) {
        Map<LottoResult, Integer> resultMap = initResultMap(winningNumbers, lottoTickets);
        Money totalReward = calculateTotalReward(resultMap);
        long revenueRate = totalReward.divideBy(inputMoney);

        return new LottoStatistics(resultMap, revenueRate);
    }

    private static Map<LottoResult, Integer> initResultMap(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        Map<LottoResult, Integer> resultMap = new EnumMap<>(LottoResult.class);

        for (LottoResult lottoResult : LottoResult.values()) {
            resultMap.put(lottoResult, 0);
        }

        for (LottoTicket ticket : lottoTickets) {
            LottoResult result = winningNumbers.result(ticket);
            int count = resultMap.getOrDefault(result, 0);
            resultMap.put(result, count + 1);
        }

        return resultMap;
    }

    private static Money calculateTotalReward(Map<LottoResult, Integer> resultMap) {
        long totalPrice = 0;

        for (Map.Entry<LottoResult, Integer> resultEntry : resultMap.entrySet()) {
            LottoResult lottoResult = resultEntry.getKey();
            int count = resultEntry.getValue();
            totalPrice += lottoResult.getTotalReward(count);
        }

        return new Money(totalPrice);
    }

    public Map<LottoResult, Integer> getResultMap() {
        return resultMap;
    }

    public long getRevenueRate() {
        return revenueRate;
    }
}
