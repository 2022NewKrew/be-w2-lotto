package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRankMatch {
    private static final Map<LottoRank, Integer> lottoResult = null;

    public static Map<LottoRank, Integer> createLottoRankResult(LottoRepository autoLottos, List<Integer> inputLastWeekWinNumber) {
//        lottoResult.put(new HashMap<LottoRank, Integer>());
        for (Lotto autoLotto : autoLottos.getLottos()) {
            Rank rank =
        }
    }

    public static LottoRank createLottoRank()
}
