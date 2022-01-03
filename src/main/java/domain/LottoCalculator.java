package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    public static LottoResult calculate(int inputMoney, List<Lotto> lottoList, List<Integer> winLottoNumbers) {

        List<Integer> matchedList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            int numOfMatched = lotto.getNumOfMatched(winLottoNumbers);
            matchedList.add(numOfMatched);
        }

        return new LottoResult(matchedList, inputMoney);
    }

}
