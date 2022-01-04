package be.w2.lotto.domain;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import static be.w2.lotto.common.exception.ExceptionMessages.DIVIDE_BY_ZERO_EXCEPTION;

public class WinningResult {
    private final List<WinningMatchResult> winningMatchResults;
    private final BigInteger profitRate;

    private WinningResult(List<WinningMatchResult> winningMatchResults, BigInteger profitRate) {
        this.winningMatchResults = winningMatchResults;
        this.profitRate = profitRate;
    }

    public static WinningResult valueOf(
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            int purchaseAmount,
            BonusNumber bonusNumber
    ) {
        List<WinningMatchResult> winningMatchResults = getWinningMatchResult(lottoTickets, winningLottoTicket, bonusNumber);
        BigInteger profitRate = calculateProfitRate(winningMatchResults, purchaseAmount);
        return new WinningResult(winningMatchResults, profitRate);
    }

    public BigInteger getProfitRate() {
        return profitRate;
    }

    public List<WinningMatchResult> getWinningMatchResults() {
        return winningMatchResults;
    }

    private static BigInteger calculateProfitRate(List<WinningMatchResult> winningMatchResults, int purchaseAmount) {
        BigInteger profitSum = winningMatchResults.stream()
                .map(WinningMatchResult::calculateProfit)
                .reduce(BigInteger::add).get();

        if (purchaseAmount == 0) {
            throw new ArithmeticException(DIVIDE_BY_ZERO_EXCEPTION);
        }
        
        return profitSum.multiply(MULTIPLY_BY_PERCENTAGE).divide(BigInteger.valueOf(purchaseAmount));
    }

    private static List<WinningMatchResult> getWinningMatchResult(
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        return rewardRules.stream()
                .map(rewardRule -> WinningMatchResult.valueOf(
                        rewardRule,
                        lottoTickets,
                        winningLottoTicket,
                        bonusNumber
                )).collect(Collectors.toList());
    }

    private static final List<RewardRule> rewardRules = List.of(
            RewardRule.valueOf(3, false, 5000),
            RewardRule.valueOf(4, false, 50000),
            RewardRule.valueOf(5, false, 1500000),
            RewardRule.valueOf(5, true, 30000000),
            RewardRule.valueOf(6, false, 2000000000)
    );

    private static final BigInteger MULTIPLY_BY_PERCENTAGE = BigInteger.valueOf(100);
}
