package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoResult, Integer> resultMap = new EnumMap<>(LottoResult.class);

    // TODO: 팩토리 메서드에서 다음 작업을 하도록 수정
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
        // TODO: 번호와 보너스 볼 매칭을 구하는 것을 LottoTicket에 메세지로 넘기기
        // TODO: LottoResult result = lottoTicket.result(winningNumbers)로 합쳐보기
        int matchCountPerTicket = getMatchCount(winningNumbers, ticket);
        boolean matchBonus = isMatchedBonus(winningNumbers, ticket);
        LottoResult result = LottoResult.valueOf(matchCountPerTicket, matchBonus);
        if (resultMap.containsKey(result)) {
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

    private boolean isMatchedBonus(WinningNumbers winningNumbers, LottoTicket lottoTicket) {
        return lottoTicket.contains(winningNumbers.getBonusNumber());
    }

    public Map<LottoResult, Integer> getResultMap() {
        return resultMap;
    }

    // TODO: totalReward, revenueRate을 LottoStatistics의 상태값으로 가지고 있도록 수정
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
