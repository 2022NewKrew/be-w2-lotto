package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    public static LottoTotalResult calculate(int inputMoney, List<Lotto> lottoList, List<Integer> winLottoNumbers) {

        List<Integer> matchedList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            int numOfMatched = lotto.getNumOfMatched(winLottoNumbers);
            matchedList.add(numOfMatched);
        }

        return new LottoTotalResult(matchedList, inputMoney);
    }

}
