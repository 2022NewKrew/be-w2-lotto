package lotto.domain.winning;

import java.util.List;
import java.util.Map;

public final class EarningRate {

    private EarningRate() {
    }

    public static int calculate(Map<String, Long> winningResult, int lottoPrice) {
        int sumResult = winningResult.keySet().stream()
                .map(key -> WinningCalc.findCalc(key).calc(winningResult.get(key)))
                .reduce(0, Integer::sum);

        return earningCalculate(sumResult, lottoPrice);
    }

    private static int earningCalculate(int sumResult, int lottoPrice) {
        double result = ((double) sumResult) / ((double) lottoPrice) * 100;
        return (int) result;
    }
}
