package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> result = new EnumMap<>(Map.of(   // key : 등수 , value : 'key'등에 당첨된 로또 개수
            LottoPrize.FIFTH_PLACE,0,
            LottoPrize.FOURTH_PLACE,0,
            LottoPrize.THIRD_PLACE,0,
            LottoPrize.SECOND_PLACE,0,
            LottoPrize.FIRST_PLACE,0,
            LottoPrize.NONE, 0
    ));
    private final LottoWinningNumber lottoWinningNumber;

    public LottoResult() {
        lottoWinningNumber = InputView.inputLastWinningNumbers();
    }

    /**
     * 구매한 로또들의 당첨 여부를 확인하는 메소드
     *
     * Map<LottoPrize, Integer> result 에 결과 저장
     */
    public void checkAllLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            putResult(lottoWinningNumber.match(lotto));
        }

        OutputView.printResult(result);
        OutputView.printYield(calculateYield(lottoList.size()));
    }

    private void putResult(LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.NONE) return; // 당첨 안 된 경우 (3개 미만 일치)
        result.put(lottoPrize, result.get(lottoPrize) + 1);
    }

    private long totalReward() {
        long totalReward = 0;

        for (LottoPrize lottoPrize : result.keySet()){
            totalReward += (long) result.get(lottoPrize) * lottoPrize.getReward();
        }
        return totalReward;
    }

    private double calculateYield(int countOfLotto) { // 수익률 계산
        final int totalPurchase = countOfLotto * LottoMachine.LOTTO_PRICE;

        if (totalPurchase == 0)
            return 0;
        return (double) (totalReward() - totalPurchase) / totalPurchase * 100;
    }
}
