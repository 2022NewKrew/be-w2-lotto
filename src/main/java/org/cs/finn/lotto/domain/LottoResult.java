package org.cs.finn.lotto.domain;

import org.cs.finn.lotto.domain.lotto.LottoNumbers;
import org.cs.finn.lotto.domain.lotto.LottoPrize;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    public static final int ADDITIVE = 1;

    private final Map<LottoPrize, Integer> mapCount = new LinkedHashMap<>();
    private final Map<LottoPrize, Lottos> mapLottos = new LinkedHashMap<>();

    public LottoResult(final LottoWinnings lottoWinnings, final Lottos lottos) {
        Objects.requireNonNull(lottoWinnings);
        Objects.requireNonNull(lottos);

        initialize();
        for (LottoNumbers lottoNumbers : lottos.getList()) {
            countResult(lottoWinnings, lottoNumbers);
        }
    }

    private void initialize() {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            mapCount.put(lottoPrize, 0);
            mapLottos.put(lottoPrize, new Lottos());
        }
    }

    private void countResult(
            final LottoWinnings winnings,
            final LottoNumbers lottoNumbers
    )
    {
        final int cntMatch = countMatchNumbers(lottoNumbers, winnings);
        final boolean bonusFound = lottoNumbers.contains(winnings.getBonusNumber());
        final LottoPrize lottoPrize = LottoPrize.find(cntMatch, bonusFound);

        mapCount.put(lottoPrize, mapCount.get(lottoPrize) + ADDITIVE);
        mapLottos.get(lottoPrize).add(lottoNumbers);
    }

    private int countMatchNumbers(final LottoNumbers lottoNumbers, final LottoWinnings winnings) {
        return winnings.getWinningsList()
                .stream()
                .filter(lottoNumbers::contains)
                .mapToInt(e -> 1)
                .sum();
    }

    public int getTotalLottos() {
        int total = 0;
        for (Integer i : mapCount.values()) {
            total += i;
        }
        return total;
    }

    public Map<LottoPrize, Integer> getMapCount() {
        return Collections.unmodifiableMap(mapCount);
    }

    public Map<LottoPrize, Lottos> getMapLottos() {
        return Collections.unmodifiableMap(mapLottos);
    }
}
