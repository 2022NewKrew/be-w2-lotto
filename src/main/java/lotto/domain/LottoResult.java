package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static lotto.domain.LottoInfo.*;

public class LottoResult {
    private final Map<Rank, Integer> countOfRank;
    private final int lottoProfit;

    public LottoResult(List<Lotto> lottoList, WinningLotto winningLotto) {
        countOfRank = new HashMap<>();
        initCountOfRank(lottoList, winningLotto);
        lottoProfit = calculateProfit();
    }

    private void initCountOfRank(List<Lotto> lottoList, WinningLotto winningLotto) {
        lottoList.forEach(lotto -> {
            LottoMatchResult lottoMatchResult = lotto.countMatchedNumber(winningLotto);
            plusCountOfRank(lottoMatchResult);
        });
    }

    private void plusCountOfRank(LottoMatchResult lottoMatchResult) {
        if (lottoMatchResult.getCount() < MIN_MATCH_COUNT.getValue())
            return;
        Rank rank = Rank.valueOf(lottoMatchResult);
        countOfRank.put(rank, getCountOfRank(rank) + 1);
    }

    private int calculateProfit() {
        return countOfRank.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    public int getLottoProfit() {
        return lottoProfit;
    }

    public int getCountOfRank(Rank rank) {
        return Optional.ofNullable(countOfRank.get(rank)).orElse(0);
    }
}