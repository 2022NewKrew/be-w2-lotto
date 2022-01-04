package service;

import domain.Lotto;
import domain.LottoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        boolean count = false;

        for (int lottoIndex = 0; lottoIndex < autoLotto.getLotto().size(); lottoIndex++) {
            if (Objects.equals(num, autoLotto.getLotto().get(lottoIndex))) {
                count = true;
                break;
            }
        }
        return count;
    }

}
