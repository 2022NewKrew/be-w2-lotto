package domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

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
            lottoResult.compute(lottoRank, (k, v) -> (v == null) ? 0 : v + 1);

        }
        lottoResult.remove(LottoRank.MISS);
        return new LottoRankMatch(lottoResult);
    }

    private static LottoRank createLottoRank(Lotto autoLotto, Set<Integer> inputLastWeekWinNumber, Integer bonusNumber) {
        boolean flag;
        flag = autoLotto.contains(bonusNumber);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(inputLastWeekWinNumber, bonusNumber);
        return LottoRank.valueOf(lottoWinningNumber.checkMatchedNumbers(autoLotto, inputLastWeekWinNumber), flag);
    }
}
