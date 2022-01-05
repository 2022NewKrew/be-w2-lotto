package lotto.domain.game;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningLotto;

public class LottoRankCount {

    private static final long REDUCE_BASE = 0L;

    private final Map<LottoRank, Long> lottoRankCount;

    public static LottoRankCount of(WinningLotto winningLotto, LottoTickets lottoTickets) {
        return new LottoRankCount(lottoTickets.toLottoRanks(winningLotto)
            .stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    private LottoRankCount(Map<LottoRank, Long> lottoRankCount) {
        this.lottoRankCount = lottoRankCount;
    }

    public long calculateTotalPrizeMoney() {
        return lottoRankCount.entrySet().stream()
            .map(entry -> entry.getKey().calculatePrizeMoneyWithCount(entry.getValue()))
            .reduce(REDUCE_BASE, Long::sum);
    }

    public Map<LottoRank, Long> getLottoRankCount() {
        return Collections.unmodifiableMap(lottoRankCount);
    }
}
