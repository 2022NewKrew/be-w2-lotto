package service;

import domain.Lotto;
import domain.LottoRepository;

import java.util.ArrayList;
import java.util.List;

public class LottoGameService {

    public static List<Integer> createResult(LottoRepository autuLottos, List<Integer> inputLastWeekWinNumber) {
        List<Integer> result = new ArrayList<>(4);
        for (Lotto autoLotto : autuLottos.getLottos()) {
            Integer matchedCount = checkNum(autoLotto, inputLastWeekWinNumber);
        }
        return result;
    }

    public static int checkNum(Lotto autoLotto, List<Integer> inputLastWeekWinNumbers) {
        return (int) inputLastWeekWinNumbers.stream()
                .filter(inputLastWeekWinNumber -> checkLotto(autoLotto, inputLastWeekWinNumber))
                .count();
    }

    public static Boolean checkLotto(Lotto autoLotto, Integer num) {
        for (int lottoIndex = 0; lottoIndex < autoLotto.getLottoSize(); lottoIndex++) {
            if (numInLotto(autoLotto.getLotto().get(lottoIndex), num)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean numInLotto(int lottoNum, int num) {
        return lottoNum == num;
    }
}
