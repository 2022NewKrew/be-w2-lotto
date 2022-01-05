package domain;

import enums.Prize;

import java.util.EnumMap;
import java.util.List;

public class LottoResult {
    private static void InitializeMap(EnumMap<Prize, Integer> lottoResult) {
        for (Prize prize : Prize.values()) {
            lottoResult.put(prize, 0);
        }
    }

    public static EnumMap<Prize, Integer> winningLottoCount(List<Integer> lastWeekWinningNumbers, List<Lotto> lottoList) {
        EnumMap<Prize, Integer> lottoResult = new EnumMap<>(Prize.class);

        InitializeMap(lottoResult);
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.checkMatchCount(lastWeekWinningNumbers);
            lottoResult.put(Prize.valueOf(matchCount), lottoResult.get(Prize.valueOf(matchCount)) + 1);
        }
        return lottoResult;
    }

    public static double rateOfReturn(List<Integer> lastWeekWinningNumbers, int purchaseAmount) {
        // TODO - 수익률을 계산하는 메소드
        return -64.28;
    }
}
