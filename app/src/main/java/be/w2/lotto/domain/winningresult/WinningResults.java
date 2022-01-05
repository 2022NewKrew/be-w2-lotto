package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResults {
    private final List<WinningResult> winningResults;
    private final ProfitRate profitRate;

    private WinningResults(List<WinningResult> winningResults, ProfitRate profitRate) {
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
        ProfitRate profitRate = ProfitRate.valueOf(winningResults, purchaseAmount);
        return new WinningResults(winningResults, profitRate);
    }

    public BigInteger getProfitRate() {
        return profitRate.getProfitRate();
    }

    public List<WinningResult> getWinningMatchResults() {
        return winningResults;
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
}
