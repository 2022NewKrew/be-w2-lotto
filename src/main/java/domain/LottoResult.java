package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static Map<Integer, Integer> winningLottoCount(List<Integer> lastWeekWinningNumbers) {
        Map<Integer, Integer> lottoResult = new HashMap<>();
        // TODO - 당첨 개수 계산
        // TODO - Lotto의 checkMatchCount() 활용
        lottoResult.put(3, 1);
        lottoResult.put(4, 0);
        lottoResult.put(5, 0);
        lottoResult.put(6, 0);
        return lottoResult;
    }

    public static double rateOfReturn(List<Integer> lastWeekWinningNumbers) {
        // TODO - 수익률을 계산하는 메소드
        return -64.28;
    }
}
