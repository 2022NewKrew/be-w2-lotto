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
        Map<LottoResult, Integer> resultMap = new EnumMap<>(LottoResult.class);
        initResultMap(resultMap);

        match(resultMap, winningNumbers, lottoTickets);
        Money totalReward = calculateTotalReward(resultMap);
        long revenueRate = totalReward.divideBy(inputMoney);

        return new LottoStatistics(resultMap, revenueRate);
    }

    private static void initResultMap(Map<LottoResult, Integer> resultMap) {
        for (LottoResult lottoResult : LottoResult.values()) {
            resultMap.put(lottoResult, 0);
        }
    }

    private static void match(Map<LottoResult, Integer> resultMap, WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        for (LottoTicket ticket : lottoTickets) {
            putResult(resultMap, winningNumbers, ticket);
        }
    }

    private static void putResult(Map<LottoResult, Integer> resultMap, WinningNumbers winningNumbers, LottoTicket ticket) {
        int count = 0;
        LottoResult result = winningNumbers.result(ticket);
        if (resultMap.containsKey(result)) {
            count = resultMap.get(result);
        }
        resultMap.put(result, count + 1);
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
