package lotto.domain;

import java.util.*;

public class LottoWinningResult {

    public static final int MAX_NUMBER_OF_BONUS_BALL = 45;
    public static final int MIN_NUMBER_OF_BONUS_BALL = 1;

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
        if (bonusBallNumber > MAX_NUMBER_OF_BONUS_BALL || MIN_NUMBER_OF_BONUS_BALL < 1) {
            throw new IllegalArgumentException("보너스 볼의 숫자는 + " + MAX_NUMBER_OF_BONUS_BALL + "과 " + MAX_NUMBER_OF_BONUS_BALL + "사이여야 합니다. (현재: " + bonusBallNumber + " )");
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

    public String getLottoWinningResultMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoWinningRating lottoWinningRating : lottoWinningResults.keySet()) {
            stringBuilder.append(getEachLottoWinningResultString(lottoWinningRating, getLottoWinningCount(lottoWinningRating)));
        }

        return stringBuilder.toString();
    }

    private String getEachLottoWinningResultString(LottoWinningRating lottoWinningRating, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoWinningRating.getMatchCount());
        stringBuilder.append("개 일치");
        if (lottoWinningRating.mustHaveBonusBall()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (" + lottoWinningRating.getWinningMoney());
        stringBuilder.append("원) - ");
        stringBuilder.append(count);
        stringBuilder.append("개\n");

        return stringBuilder.toString();
    }


    public Set<LottoWinningRating> keySet() {
        return lottoWinningResults.keySet();
    }

}
