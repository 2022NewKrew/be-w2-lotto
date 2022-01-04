package domain;

import java.util.List;
import java.util.Map;

public class LottoRankMatch {
    private static final Map<LottoRank, Integer> lottoResult = null;

    public static Map<LottoRank, Integer> createLottoRankResult(LottoRepository autoLottos, List<Integer> inputLastWeekWinNumber) {
        for (Lotto autoLotto : autoLottos.getLottos()) {
            lottoResult.put(createLottoRank(autoLotto, inputLastWeekWinNumber), 0);
        }
        return lottoResult;
    }

    private static LottoRank createLottoRank(Lotto autoLotto, List<Integer> inputLastWeekWinNumber) {
        return LottoRank.find(checkMatchedNumbers(autoLotto, inputLastWeekWinNumber));
    }

    private static int checkMatchedNumbers(Lotto autoLotto, List<Integer> inputLastWeekWinNumbers) {
        return (int) inputLastWeekWinNumbers.stream()
                .filter(inputLastWeekWinNumber -> checkMatchedNumber(autoLotto, inputLastWeekWinNumber))
                .count();
    }

    private static Boolean checkMatchedNumber(Lotto autoLotto, Integer num) {
        return autoLotto.getLotto().stream()
                .anyMatch(autoLottoNumber -> checkMatchedNumberIsBoolean(autoLottoNumber, num));
    }

    private static Boolean checkMatchedNumberIsBoolean(int lottoNumber, int inputNumber) {
        return lottoNumber == inputNumber;
    }
}
