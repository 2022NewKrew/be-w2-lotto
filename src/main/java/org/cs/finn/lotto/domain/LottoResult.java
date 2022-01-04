package org.cs.finn.lotto.domain;

import org.cs.finn.lotto.domain.lotto.LottoNumber;
import org.cs.finn.lotto.domain.lotto.LottoNumbers;
import org.cs.finn.lotto.domain.lotto.LottoPrize;

import java.util.*;

public class LottoResult {

    private final Map<LottoPrize, Integer> results;

    public LottoResult(final LottoWinnings lottoWinnings, final Lottos lottos) {
        Objects.requireNonNull(lottoWinnings);
        Objects.requireNonNull(lottos);

        final Map<LottoPrize, Integer> map = new LinkedHashMap<>();
        for (LottoNumbers lottoNumbers : lottos.getList()) {
            countResult(map, lottoWinnings, lottoNumbers);
        }

        this.results = map;
    }

    private void countResult(
            final Map<LottoPrize, Integer> map,
            final LottoWinnings winnings,
            final LottoNumbers lottoNumbers
    )
    {
        final int cntMatch = countMatchNumbers(lottoNumbers, winnings);
        final boolean bBonus = lottoNumbers.contains(winnings.getBonusNumber());
        final LottoPrize lottoPrize = LottoPrize.find(cntMatch, bBonus);

        map.put(lottoPrize, map.getOrDefault(lottoPrize, 0) + 1);
    }

    private int countMatchNumbers(final LottoNumbers lottoNumbers, final LottoWinnings winnings) {
        return winnings.getWinningsList()
                .stream()
                .filter(lottoNumbers::contains)
                .mapToInt(e -> 1)
                .sum();
    }

    public Map<LottoPrize, Integer> getResultMap() {
        return Collections.unmodifiableMap(results);
    }
}
