package domain.lotto;

import domain.prize.Prize;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    public static LottoTotalResult calculate(int inputMoney, List<Lotto> lottoList, WinningLotto winningLotto) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            createNewLottoResult(lottoResults, lotto, winningLotto);
        }
        return new LottoTotalResult(lottoResults, inputMoney);
    }

    private static void createNewLottoResult(List<LottoResult> lottoResults, Lotto lotto, WinningLotto winningLotto) {
        int matchedNum = lotto.getNumOfMatched(winningLotto);
        boolean bonusMatched = lotto.isBonusMatched(winningLotto.getBonusNumber());
        LottoResult lottoResult = new LottoResult(matchedNum, bonusMatched);

        if (lottoResult.getPrizeType() != Prize.NO_PRIZE) {
            lottoResults.add(lottoResult);
        }
    }

}
