package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final WinningNumbers winningNumbers;
    private Map<LottoResult, Integer> resultMap = new EnumMap<>(LottoResult.class);

    public LottoStatistics (WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        this.winningNumbers = winningNumbers;
        match(lottoTickets);
    }

    private void match(LottoTickets lottoTickets) {
        for (LottoTicket ticket : lottoTickets) {
            putResult(resultMap, ticket);
        }
    }

    private void putResult(Map<LottoResult, Integer> resultMap, LottoTicket ticket) {
        int count = 0;

        LottoResult result = LottoResult.valueOf(getMatchCount(ticket));
        if (resultMap.get(result) != null) {
            count = resultMap.get(result);
        }

        resultMap.put(result, count + 1);
    }

    private int getMatchCount(LottoTicket lottoTicket) {
        int matchCount = 0;

        for (LottoNumber number : winningNumbers) {
            matchCount += lottoTicket.contains(number) ? 1 : 0;
        }

        return matchCount;
    }

    public Map<LottoResult, Integer> getResultMap() {
        return resultMap;
    }

    public int calculateRevenueRate(Money money) {
        long totalPrice = 0;

        for (Map.Entry<LottoResult, Integer> resultEntry : resultMap.entrySet()) {
            LottoResult lottoResult = resultEntry.getKey();
            int count = resultEntry.getValue();

            totalPrice += lottoResult.getReward() * count;
        }

        return (int) (totalPrice / money.getPrice()) * 100;
    }
}
