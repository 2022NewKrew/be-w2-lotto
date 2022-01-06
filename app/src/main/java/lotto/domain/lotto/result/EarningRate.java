package lotto.domain.lotto.result;

import java.util.Map;

public final class EarningRate {

    private EarningRate() {
    }

    public static int calculate(Map<WinningRanking, Long> winningResult, int lottoPrice) {
        int sumResult = winningResult.keySet().stream()
                .map(ranking -> ranking.calculatePrizeAccordingToRanking(winningResult.get(ranking)))
                .reduce(0, Integer::sum);

        return earningCalculate(sumResult, lottoPrice);
    }

    private static int earningCalculate(int sumResult, int lottoPrice) {
        double result = ((double) sumResult) / ((double) lottoPrice) * 100;
        return (int) result;
    }
}
