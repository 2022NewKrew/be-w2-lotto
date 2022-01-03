package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static lotto.domain.LottoInfo.*;

public class LottoResult {
    private final Map<Rank, Integer> countOfRank;
    private final int lottoProfit;

    public LottoResult(List<Lotto> lottoList, List<Integer> winningNumbers) {
        countOfRank = new HashMap<>();
        initCountOfRank(lottoList, winningNumbers);
        lottoProfit = calculateProfit();
    }

    private void initCountOfRank(List<Lotto> lottoList, List<Integer> winningNumbers) {
        lottoList.forEach(lotto -> {
            int matchCount = lotto.countMatchedNumber(winningNumbers);
            plusCountOfRank(matchCount);
        });
    }

    private void plusCountOfRank(int matchCount) {
        if (matchCount < MIN_MATCH_COUNT.getValue())
            return;
        Rank rank = Rank.valueOf(matchCount);
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