package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;
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

    private static BigInteger calculateProfitRate(List<WinningMatchResult> winningMatchResults, int purchaseAmount)
            throws NoSuchElementException, ArithmeticException
    {
        BigInteger profitSum = winningMatchResults.stream()
                .map(WinningMatchResult::calculateProfit)
                .reduce(BigInteger::add).orElseThrow(NoSuchElementException::new);

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
        return Reward.stream()
                .map(reward -> WinningMatchResult.valueOf(
                        reward,
                        lottoTickets,
                        winningLottoTicket,
                        bonusNumber
                ))
                .collect(Collectors.toList());
    }

    private static final BigInteger MULTIPLY_BY_PERCENTAGE = BigInteger.valueOf(100);
}
