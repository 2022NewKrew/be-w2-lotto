package be.w2.lotto.domain.winningresult;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;

import static be.w2.lotto.common.exception.ExceptionMessages.DIVIDE_BY_ZERO_EXCEPTION;

public class ProfitRate {
    private final BigInteger profitRate;

    public ProfitRate(BigInteger profitRate) {
        this.profitRate = profitRate;
    }

    public static ProfitRate valueOf(List<WinningResult> winningResults, int purchaseAmount) {
        calculateProfitRate(winningResults, purchaseAmount);
        BigInteger profitRate = calculateProfitRate(winningResults, purchaseAmount);
        return new ProfitRate(profitRate);
    }

    public BigInteger getProfitRate() {
        return profitRate;
    }

    private static BigInteger calculateProfitRate(List<WinningResult> winningResults, int purchaseAmount)
            throws NoSuchElementException, ArithmeticException
    {
        BigInteger profitSum = winningResults.stream()
                .map(WinningResult::calculateProfit)
                .reduce(BigInteger::add)
                .orElseThrow(NoSuchElementException::new);

        if (purchaseAmount == 0) {
            throw new ArithmeticException(DIVIDE_BY_ZERO_EXCEPTION);
        }

        return profitSum.multiply(MULTIPLY_BY_PERCENTAGE).divide(BigInteger.valueOf(purchaseAmount));
    }

    private static final BigInteger MULTIPLY_BY_PERCENTAGE = BigInteger.valueOf(100);
}
