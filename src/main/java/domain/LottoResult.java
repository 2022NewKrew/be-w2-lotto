package domain;

import enums.Prize;

import java.util.EnumMap;
import java.util.List;

public class LottoResult {
    public static EnumMap<Prize, Integer> winningLottoCount(List<Integer> lastWeekWinningNumbers, List<Lotto> lottoList) {
        EnumMap<Prize, Integer> lottoResult = new EnumMap<>(Prize.class);
        // TODO - 당첨 개수 계산
        // TODO - Lotto의 checkMatchCount() 활용
        lottoResult.put(Prize.FIFTH, 1);
        lottoResult.put(Prize.FOURTH, 0);
        lottoResult.put(Prize.THIRD, 0);
        lottoResult.put(Prize.FIRST, 0);
        return lottoResult;
    }

    public static double rateOfReturn(List<Integer> lastWeekWinningNumbers, int purchaseAmount) {
        // TODO - 수익률을 계산하는 메소드
        return -64.28;
    }
}
