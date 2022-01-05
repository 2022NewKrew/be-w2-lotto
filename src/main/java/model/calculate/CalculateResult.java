package model.calculate;

import constants.RankInfo;
import parameters.LottoResult;
import parameters.UserLottoLines;

import java.util.List;

public class CalculateResult {

    public static LottoResult getLottoResult(UserLottoLines userLottoLines, List<Integer> winningNumbers, int bonus) {
        LottoResult lottoResult = new LottoResult();
        userLottoLines.getUserLottoLinesStream()
                .forEach(line -> {
                    boolean checkBonus = line.checkBonus(bonus);
                    long count = line.getNumbersStream()
                            .filter(winningNumbers::contains)
                            .count();
                    lottoResult.addCountToResult(RankInfo.valueOf(getRanking(count), checkBonus));
                });
        return lottoResult;
    }

    private static int getRanking(long count) {
        if (count > RankInfo.FAIL.getCount()) {
            return (int) count;
        }
        return RankInfo.FAIL.getCount();
    }
}
