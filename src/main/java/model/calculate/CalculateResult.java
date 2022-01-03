package model.calculate;

import constants.LottoRule;
import parameters.LottoResult;
import parameters.UserLottoLines;

import java.util.List;

public class CalculateResult {

    public LottoResult getLottoResult(UserLottoLines userLottoLines, List<Integer> winningNumbers){
        LottoResult lottoResult = new LottoResult();
        userLottoLines.getUserLottoLinesStream()
                .forEach(line -> {
                    long count = line.getNumbersStream()
                            .filter(winningNumbers::contains)
                            .count();
                    lottoResult.addCountToResult(getRanking(count));
                });
        return lottoResult;
    }

    private int getRanking(long count){
        if(count > LottoRule.FAIL) { return (int) count; }
        return LottoRule.FAIL;
    }
}
