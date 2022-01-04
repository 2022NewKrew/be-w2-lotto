package lotto.domain;

import java.util.*;

public class LottoWinningResult {

    private Map<LottoWinningRating, Integer> lottoWinningResults;

    public LottoWinningResult(List<Integer> winningNumbers, List<Lotto> lottoList) {
        makeLottoWinningResults(winningNumbers, lottoList);
    }

    private void makeLottoWinningResults(List<Integer> winningNumbers, List<Lotto> lottoList) {
        initLottoWinningResults();
        for (Lotto lotto : lottoList) {
            LottoWinningRating result = lotto.getWinningRating(winningNumbers);
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

    public long getYield(int wholeLottoPrice) {
        int earnedMoney = 0;
        for (LottoWinningRating lottoWinningRating : lottoWinningResults.keySet()) {
            earnedMoney += lottoWinningRating.getWinningMoney() * lottoWinningResults.get(lottoWinningRating);
        }

        return (earnedMoney * 100L) / wholeLottoPrice;
    }

    public int getLottoWinningCount(LottoWinningRating lottoWinningRating) {
        return lottoWinningResults.get(lottoWinningRating);
    }

    public Set<LottoWinningRating> keySet() {
        return lottoWinningResults.keySet();
    }
}
