package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRankMatch {
    private static final Map<LottoRank, Integer> lottoResult = null;

    public static Map<LottoRank, Integer> createLottoRankResult(LottoRepository autoLottos, List<Integer> inputLastWeekWinNumber) {
//        lottoResult.put(new HashMap<LottoRank, Integer>());
        for (Lotto autoLotto : autoLottos.getLottos()) {
            lottoResult.put(c)
        }
        autoLottos.getLottos().stream().filter(autoLotto -> )
    }

    public static LottoRank createLottoRank(Lotto autoLotto, List<Integer> inputLastWeekWinNumber) {
        LottoRank lottoRank  checkMatchedNumbers(autoLotto, inputLastWeekWinNumber)
    }

    public static int checkMatchedNumbers(Lotto autoLotto, List<Integer> inputLastWeekWinNumbers) {
        return (int) inputLastWeekWinNumbers.stream()
                .filter(inputLastWeekWinNumber -> checkMatchedNumber(autoLotto, inputLastWeekWinNumber))
                .count();
    }

    public static Boolean checkMatchedNumber(Lotto autoLotto, Integer num) {
        for (int lottoIndex = 0; lottoIndex < autoLotto.getLottoSize(); lottoIndex++) {
            if (checkMatchedNumberIsBoolean(autoLotto.getLotto().get(lottoIndex), num)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkMatchedNumberIsBoolean(int lottoNumber, int inputNumber) {
        return lottoNumber == inputNumber;
    }
}
