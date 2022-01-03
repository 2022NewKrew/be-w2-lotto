package lotto.domain;

import java.util.*;

public class LottoWinningResult {

    private Map<LottoWinningRating, Integer> lottoWinningResults;

    public LottoWinningResult(List<Integer> winningNumbers, List<LottoRow> lottoRows) {
        makeLottoWinningResults(winningNumbers, lottoRows);
    }

    private void makeLottoWinningResults(List<Integer> winningNumbers, List<LottoRow> lottoRows) {
        initLottoWinningResults();
        for (LottoRow lottoRow : lottoRows) {
            LottoWinningRating result = lottoRow.getWinningRating(winningNumbers);
            Integer count = lottoWinningResults.get(result);
            lottoWinningResults.put(result, count + 1);
        }
        lottoWinningResults.remove(LottoWinningRating.NOTHING);
    }

    private void initLottoWinningResults() {
        lottoWinningResults = new EnumMap<>(LottoWinningRating.class);
        Arrays.stream(LottoWinningRating.values())
                .forEach(lottoWinningRating -> lottoWinningResults.put(lottoWinningRating, 0));
    }

    public Integer getYield(Integer wholeLottoPrice) {
        int earnedMoney = 0;
        for (LottoWinningRating lottoWinningRating : lottoWinningResults.keySet()) {
            earnedMoney += lottoWinningRating.getWinningMoney() * lottoWinningResults.get(lottoWinningRating);
        }

        return (earnedMoney * 100) / wholeLottoPrice;
    }

    public Integer getLottoWinningCount(LottoWinningRating lottoWinningRating) {
        return lottoWinningResults.get(lottoWinningRating);
    }

    public Set<LottoWinningRating> keySet() {
        return lottoWinningResults.keySet();
    }
}
