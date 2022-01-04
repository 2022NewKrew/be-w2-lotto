package be.w2.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningMatchResult {
    private final int matchedNumber;
    private final int profit;
    private final int count;

    private WinningMatchResult(int matchedNumber, int profit, int count) {
        this.matchedNumber = matchedNumber;
        this.profit = profit;
        this.count = count;
    }

    public static WinningMatchResult of(
            int matchedNumber,
            int profit,
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket
    ) {
        int count = getCount(matchedNumber, lottoTickets, winningLottoTicket);
        return new WinningMatchResult(matchedNumber, profit, count);
    }

    public int calculateProfit() {
        return profit * count;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getProfit() {
        return profit;
    }

    public int getCount() {
        return count;
    }

    private static int getCount(int matchedNumber, LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket) {
        return (int) lottoTickets.getLottoTickets()
                .stream().filter(lottoTicket -> matchesByMatchedNumber(matchedNumber, lottoTicket, winningLottoTicket))
                .count();
    }

    private static boolean matchesByMatchedNumber(
            int matchedNumber,
            LottoTicket lottoTicket,
            WinningLottoTicket winningLottoTicket
    ) {
        List<Integer> listedTicket = lottoTicket.getLottoNumbers()
                .stream().map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());

        List<Integer> listedWinningTicket = winningLottoTicket.getLottoNumbers()
                .stream().map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());

        listedTicket.retainAll(listedWinningTicket);
        return listedTicket.size() == matchedNumber;
    }
}
