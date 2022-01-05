package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoGameResult {

    private static final double RATE_BASE = 100.0;
    private static final long REDUCE_LONG_IDENTITY = 0L;

    private final Map<LottoRank, Long> lottoRankCount;
    private final double profitRate;

    public static LottoGameResult of(WinningLotto winningLotto, List<Lotto> lottoTickets,
        int purchasePrice) {
        return new LottoGameResult(winningLotto, lottoTickets, purchasePrice);
    }

    private LottoGameResult(WinningLotto winningLotto, List<Lotto> lottoTickets,
        int purchasePrice) {
        lottoRankCount = lottoTickets.stream()
            .map(lottoTicket -> LottoRank.valueOf(winningLotto, lottoTicket))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long totalPrizeMoney = lottoRankCount.entrySet().stream()
            .map(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
            .reduce(REDUCE_LONG_IDENTITY, Long::sum);

        profitRate =
            (double) (totalPrizeMoney - purchasePrice) / (double) purchasePrice * RATE_BASE;
    }

    public Map<LottoRank, Long> getLottoRankCount() {
        return Collections.unmodifiableMap(lottoRankCount);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
