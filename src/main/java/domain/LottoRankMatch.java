package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankMatch {
    private final Map<LottoRank, Integer> lottoResult;

    private LottoRankMatch(Map<LottoRank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    private static Map<LottoRank, Integer> initResult() {
        Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
        return lottoResult;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public static LottoRankMatch createResult(LottoRepository autoLottos, LottoWinningNumber inputLastWeekWinNumber) {
        Map<LottoRank, Integer> lottoResult = initResult();
        for (Lotto autoLotto : autoLottos.getLottos()) {
            LottoRank lottoRank = createLottoRank(autoLotto, inputLastWeekWinNumber.getLotto(), inputLastWeekWinNumber.getBonus());
            lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
        }
        return new LottoRankMatch(lottoResult);
    }

    private static LottoRank createLottoRank(Lotto autoLotto, List<Integer> inputLastWeekWinNumber, Integer bonus) {
        boolean flag;
        flag = autoLotto.getLotto().contains(bonus);
        return LottoRank.valueOf(checkMatchedNumbers(autoLotto, inputLastWeekWinNumber), flag);
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
