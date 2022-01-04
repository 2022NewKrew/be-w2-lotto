package be.w2.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static be.w2.lotto.common.exception.ExceptionMessages.DIVIDE_BY_ZERO_EXCEPTION;

public class WinningResult {
    private final List<WinningMatchResult> winningMatchResults;
    private final int profitRate;

    private WinningResult(List<WinningMatchResult> winningMatchResults, int profitRate) {
        this.winningMatchResults = winningMatchResults;
        this.profitRate = profitRate;
    }

    public static WinningResult valueOf(
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            int purchaseAmount
    ) {
        List<WinningMatchResult> winningMatchResults = getWinningMatchResult(lottoTickets, winningLottoTicket);
        int profitRate = calculateProfitRate(winningMatchResults, purchaseAmount);
        return new WinningResult(winningMatchResults, profitRate);
    }

    public int getProfitRate() {
        return profitRate;
    }

    public List<WinningMatchResult> getWinningMatchResults() {
        return winningMatchResults;
    }

    private static int calculateProfitRate(List<WinningMatchResult> winningMatchResults, int purchaseAmount) {
        int profitSum = winningMatchResults
                .stream().map(WinningMatchResult::calculateProfit)
                .mapToInt(i -> i)
                .sum();

        if (purchaseAmount == 0) {
            throw new ArithmeticException(DIVIDE_BY_ZERO_EXCEPTION);
        }
        
        return profitSum * MULTIPLY_BY_PERCENTAGE / purchaseAmount;
    }

    private static List<WinningMatchResult> getWinningMatchResult(
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket
    ) {
        List<WinningMatchResult> winningMatchResults = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: winningProfitMapped.entrySet()) {
            winningMatchResults.add(WinningMatchResult.of(
                    entry.getKey(),
                    entry.getValue(),
                    lottoTickets,
                    winningLottoTicket
            ));
        }
        return winningMatchResults;
    }

    private static final Map<Integer, Integer> winningProfitMapped = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );

    private static final int MULTIPLY_BY_PERCENTAGE = 100;
}
