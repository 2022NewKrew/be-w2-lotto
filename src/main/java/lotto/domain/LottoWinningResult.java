package lotto.domain;

import java.util.*;

public class LottoWinningResult {

    private Map<LottoWinningRating, Integer> lottoWinningResults;

    public LottoWinningResult(List<Integer> winningNumbers, int bonusBallNumber, List<Lotto> lottoList) {
        validateBonusBallNumber(bonusBallNumber);
        makeLottoWinningResults(winningNumbers, bonusBallNumber, lottoList);
    }

    private void makeLottoWinningResults(List<Integer> winningNumbers, int bonusBallNumber, List<Lotto> lottoList) {
        initLottoWinningResults();
        for (Lotto lotto : lottoList) {
            LottoWinningRating result = lotto.getWinningRating(winningNumbers, bonusBallNumber);
            int count = lottoWinningResults.get(result);
            lottoWinningResults.put(result, count + 1);
        }
        lottoWinningResults.remove(LottoWinningRating.NOTHING);
    }

    private void validateBonusBallNumber(int bonusBallNumber) {
        if (bonusBallNumber > 45 || bonusBallNumber < 1) {
            throw new IllegalArgumentException("보너스 볼의 숫자는 1과 45사이여야 합니다. (현재: " + bonusBallNumber + " )");
        }
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
