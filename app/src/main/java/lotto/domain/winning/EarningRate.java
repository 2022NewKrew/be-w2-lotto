package lotto.domain.winning;

import java.util.Map;

public final class EarningRate {

    private EarningRate() {
    }

    public static int calculate(Map<Integer, Integer> winningResult, int lottoPrice) {
        int sumResult = winningResult.keySet().stream()
                .map(key -> multiplication(winningResult.get(key), earningCase(key)))
                .reduce(Integer::sum)
                .get();

        return earningCalculate(sumResult, lottoPrice);
    }

    private static int earningCalculate(int sumResult, int lottoPrice) {
        double result = ((double) sumResult) / ((double) lottoPrice) * 100;
        return (int) result;
    }

    private static int multiplication(int result, int earningResult) {
        return result * earningResult;
    }

    private static int earningCase(int caseNumber) {
        if (caseNumber == 3) {
            return 5000;
        }
        if (caseNumber == 4) {
            return 50000;
        }
        if (caseNumber == 5) {
            return 1500000;
        }
        return 2000000000;
    }
}
