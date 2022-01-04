package domain.lotto;

import domain.prize.Prize;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    public static LottoTotalResult calculate(int inputMoney, List<Lotto> lottoList, List<Integer> winLottoNumbers, int bonusLottoNumber) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            createNewLottoResult(lottoResults, lotto, winLottoNumbers, bonusLottoNumber);
        }
        return new LottoTotalResult(lottoResults, inputMoney);
    }

    private static void createNewLottoResult(List<LottoResult> lottoResults, Lotto lotto, List<Integer> winLottoNumbers, int bonusLottoNumber) {
        int matchedNum = lotto.getNumOfMatched(winLottoNumbers);
        boolean bonusMatched = lotto.isBonusMatched(bonusLottoNumber);
        LottoResult lottoResult = new LottoResult(matchedNum, bonusMatched);

        if (lottoResult.getPrizeType() != Prize.NO_PRIZE) {
            lottoResults.add(lottoResult);
        }
    }

}
