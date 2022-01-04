package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final List<Lotto> lottoList;
    private final int purchaseAmount;

    public User(List<Lotto> lottoList, int purchaseAmount) {
        this.lottoList = Collections.unmodifiableList(lottoList);
        this.purchaseAmount = purchaseAmount;
    }

    public Map<Integer, Integer> calculateLottoResult(List<Integer> lastWeekWinningNumbers) {
        Map<Integer, Integer> lottoResult = new HashMap<>();
        // TODO - 당첨 개수 계산
        // TODO - Lotto의 checkMatchCount() 활용
        lottoResult.put(3, 1);
        lottoResult.put(4, 0);
        lottoResult.put(5, 0);
        lottoResult.put(6, 0);
        return lottoResult;
    }

    public double calculateRateOfReturn(List<Integer> lastWeekWinningNumbers) {
        // TODO - 수익률을 계산하는 메소드
        return -64.28;
    }
}
