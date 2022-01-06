package domain.lotto;

import domain.prize.Prize;

import java.util.ArrayList;
import java.util.List;

import static util.LottoConst.LOTTO_PRICE;

public class LottoCalculator {

    public static LottoTotalResult calculate(List<Lotto> lottoList, WinningLotto winningLotto) {
        List<LottoResult> lottoResults = new ArrayList<>();
        int money = lottoList.size() * LOTTO_PRICE;

        for (Lotto lotto : lottoList) {
            createNewLottoResult(lottoResults, lotto, winningLotto);
        }
        return new LottoTotalResult(lottoResults, money);
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
