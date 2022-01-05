package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static be.w2.lotto.common.exception.ExceptionMessages.DIVIDE_BY_ZERO_EXCEPTION;

public class WinningResults {
    private final List<WinningResult> winningResults;
    private final BigInteger profitRate;

    private WinningResults(List<WinningResult> winningResults, BigInteger profitRate) {
        this.winningResults = winningResults;
        this.profitRate = profitRate;
    }

    public static WinningResults valueOf(
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            int purchaseAmount,
            BonusNumber bonusNumber
    ) {
        List<WinningResult> winningResults = getWinningMatchResult(lottoTickets, winningLottoTicket, bonusNumber);
        BigInteger profitRate = calculateProfitRate(winningResults, purchaseAmount);
        return new WinningResults(winningResults, profitRate);
    }

    public BigInteger getProfitRate() {
        return profitRate;
    }

    public List<WinningResult> getWinningMatchResults() {
        return winningResults;
    }

    private static BigInteger calculateProfitRate(List<WinningResult> winningResults, int purchaseAmount)
            throws NoSuchElementException, ArithmeticException
    {
        BigInteger profitSum = winningResults.stream()
                .map(WinningResult::calculateProfit)
                .reduce(BigInteger::add).orElseThrow(NoSuchElementException::new);

        if (purchaseAmount == 0) {
            throw new ArithmeticException(DIVIDE_BY_ZERO_EXCEPTION);
        }

        return profitSum.multiply(MULTIPLY_BY_PERCENTAGE).divide(BigInteger.valueOf(purchaseAmount));
    }

    private static List<WinningResult> getWinningMatchResult(
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        return Reward.stream()
                .map(reward -> WinningResult.valueOf(
                        reward,
                        lottoTickets,
                        winningLottoTicket,
                        bonusNumber
                ))
                .collect(Collectors.toList());
    }

    private static final BigInteger MULTIPLY_BY_PERCENTAGE = BigInteger.valueOf(100);
}
