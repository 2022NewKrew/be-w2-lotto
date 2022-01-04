package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoResult, Integer> resultMap = new EnumMap<>(LottoResult.class);

    public LottoStatistics (WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        initResultMap();
        match(winningNumbers, lottoTickets);
    }

    private void initResultMap() {
        for (LottoResult lottoResult : LottoResult.values()) {
            resultMap.put(lottoResult, 0);
        }
    }

    private void match(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        for (LottoTicket ticket : lottoTickets) {
            putResult(winningNumbers, ticket);
        }
    }

    private void putResult(WinningNumbers winningNumbers, LottoTicket ticket) {
        int count = 0;
        LottoResult result = LottoResult.valueOf(getMatchCount(winningNumbers, ticket));
        if (resultMap.get(result) != null) {
            count = resultMap.get(result);
        }

        resultMap.put(result, count + 1);
    }

    private int getMatchCount(WinningNumbers winningNumbers, LottoTicket lottoTicket) {
        int matchCount = 0;

        for (LottoNumber number : winningNumbers) {
            matchCount += lottoTicket.contains(number) ? 1 : 0;
        }

        return matchCount;
    }

    public Map<LottoResult, Integer> getResultMap() {
        return resultMap;
    }

    public int calculateRevenueRate(Money inputMoney) {
        long totalPrice = 0;

        for (Map.Entry<LottoResult, Integer> resultEntry : resultMap.entrySet()) {
            LottoResult lottoResult = resultEntry.getKey();
            int count = resultEntry.getValue();

            totalPrice += (long) lottoResult.getReward() * count;
        }

        Money totalMoney = new Money(totalPrice);

        return totalMoney.getRevenueRate(inputMoney);
    }
}
