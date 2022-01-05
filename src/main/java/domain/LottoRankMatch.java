package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankMatch {
    private static final Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);

    public static Map<LottoRank, Integer> createResult(LottoRepository autoLottos, List<Integer> inputLastWeekWinNumber) {
        initResult();
        for (Lotto autoLotto : autoLottos.getLottos()) {
            LottoRank lottoRank = createLottoRank(autoLotto, inputLastWeekWinNumber);
            lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
        }
        return lottoResult;
    }

    public static void initResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    private static LottoRank createLottoRank(Lotto autoLotto, List<Integer> inputLastWeekWinNumber) {
        return LottoRank.valueOf(checkMatchedNumbers(autoLotto, inputLastWeekWinNumber));
    }

    private static int checkMatchedNumbers(Lotto autoLotto, List<Integer> inputLastWeekWinNumbers) {
        return (int) inputLastWeekWinNumbers.stream()
                .filter(inputLastWeekWinNumber -> checkMatchedNumber(autoLotto, inputLastWeekWinNumber))
                .count();
    }

    private static Boolean checkMatchedNumber(Lotto autoLotto, Integer inputLastWeekWinNumber) {
        return autoLotto.getLotto().stream()
                        .anyMatch(autoLottoNumber -> (autoLottoNumber.equals(inputLastWeekWinNumber)));
    }
}
