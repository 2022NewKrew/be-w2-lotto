package domain;

import enums.Prize;

import java.util.EnumMap;
import java.util.List;

public class LottoResult {
    private final List<Integer> lastWeekWinningNumbers;

    public LottoResult(List<Integer> lastWeekWinningNumbers) {
        if (lastWeekWinningNumbers == null)
            throw new IllegalArgumentException();
        this.lastWeekWinningNumbers = lastWeekWinningNumbers;
    }

    private void InitializeMap(EnumMap<Prize, Integer> lottoResult) {
        for (Prize prize : Prize.values()) {
            lottoResult.put(prize, 0);
        }
    }

    public EnumMap<Prize, Integer> winningLottoCount(List<Lotto> lottoList) {
        EnumMap<Prize, Integer> lottoResult = new EnumMap<>(Prize.class);

        InitializeMap(lottoResult);
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.checkMatchCount(lastWeekWinningNumbers);
            lottoResult.put(Prize.valueOf(matchCount), lottoResult.get(Prize.valueOf(matchCount)) + 1);
        }
        return lottoResult;
    }

    public double rateOfReturn(int purchaseAmount) {
        // TODO - 수익률을 계산하는 메소드
        return -64.28;
    }
}
