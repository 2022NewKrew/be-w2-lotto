package carrot.ez.service;

import carrot.ez.dto.LotteryStatisticsDto;
import carrot.ez.lotto.Lotteries;
import carrot.ez.lotto.Lottery;
import carrot.ez.dto.WinningNumberDto;
import carrot.ez.lotto.Rank;

import java.util.List;
import java.util.Map;

public class LottoService {
    
    public Lotteries purchaseLotteries(long amount, List<Lottery> manualLotteries) {
        long numAutoLotteries = getNumOfAutoLotteries(amount, manualLotteries);
        return Lotteries.createLotteries(numAutoLotteries, manualLotteries);
    }

    public LotteryStatisticsDto checkWiningNumbers(Lotteries lotteries, WinningNumberDto winningNumberDto) {
        Map<Rank, Long> rankCountMap = lotteries.checkWinningNumbers(winningNumberDto.getWinningNumber(), winningNumberDto.getBonus());
        Long sum = rankCountMap.entrySet().stream()
                .map(entry -> entry.getKey().getPrice() * entry.getValue())
                .reduce(Long::sum)
                .orElseThrow();
        return new LotteryStatisticsDto(rankCountMap, sum);
    }

    private long getNumOfAutoLotteries(long amount, List<Lottery> manualLotteries) {
        long numAutoLotteries  = (amount / Lottery.LOTTO_PRICE) - manualLotteries.size();
        if (numAutoLotteries < 0) {
            throw new IllegalArgumentException("구입 금액이 부족합니다.");
        }

        return numAutoLotteries;
    }
}
