package lotto.domain;

import lotto.domain.userinput.WinningLottoDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static lotto.domain.LottoInfo.*;

public class LottoResult {
    private final Map<Rank, Integer> countOfRank;
    private final int lottoProfit;

    public LottoResult(List<Lotto> lottoList, WinningLottoDto winningLottoDto) {
        countOfRank = new HashMap<>();
        initCountOfRank(lottoList, winningLottoDto);
        lottoProfit = calculateProfit();
    }

    private void initCountOfRank(List<Lotto> lottoList, WinningLottoDto winningLottoDto) {
        lottoList.forEach(lotto -> {
            LottoMatchDto lottoMatchDto = lotto.countMatchedNumber(winningLottoDto.getWinningTicket(), winningLottoDto.getBonusBall());
            plusCountOfRank(lottoMatchDto);
        });
    }

    private void plusCountOfRank(LottoMatchDto lottoMatchDto) {
        if (lottoMatchDto.getCount() < MIN_MATCH_COUNT.getValue())
            return;
        Rank rank = Rank.valueOf(lottoMatchDto);
        countOfRank.put(rank, getCountOfRank(rank) + 1);
    }

    private int calculateProfit() {
        return countOfRank.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    public long profitRate(int purchaseMoney) {
        return (lottoProfit - purchaseMoney) * 100L / purchaseMoney;
    }

    public int getCountOfRank(Rank rank) {
        return Optional.ofNullable(countOfRank.get(rank)).orElse(0);
    }
}