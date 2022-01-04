package model.calculate;

import constants.LottoRule;
import parameters.LottoResult;
import parameters.RankInfo;
import parameters.UserLottoLines;

import java.util.List;

public class CalculateResult {

    public LottoResult getLottoResult(UserLottoLines userLottoLines, List<Integer> winningNumbers, int bonus){
        LottoResult lottoResult = new LottoResult();
        userLottoLines.getUserLottoLinesStream()
                .forEach(line -> {
                    boolean checkBonus = line.checkBonus(bonus);
                    long count = line.getNumbersStream()
                            .filter(winningNumbers::contains)
                            .count();
                    lottoResult.addCountToResult(new RankInfo(getRanking(count), checkBonus));
                });
        return lottoResult;
    }

    private int getRanking(long count){
        if(count > LottoRule.FAIL) { return (int) count; }
        return LottoRule.FAIL;
    }
}
