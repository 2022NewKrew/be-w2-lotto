package com.upperleaf.domain;

import com.upperleaf.domain.lotto.LottoRanking;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistics {

    public LottoResult getLottoResult(LottoMatcher lottoMatcher) {
        Map<LottoRanking, Long> groupLottoRanking = groupByLottoRanking(lottoMatcher);
        long profitRate = getAllWinningProfitRate(lottoMatcher);

        LottoResult result = new LottoResult(groupLottoRanking, profitRate);

        result.setLottoId(lottoMatcher.getLottosId());
        return result;
    }

    /**
     * 로또 등수에 따라 그룹화 해주는 메서드
     * @param lottoMatcher 로또 당첨 번호와 로또를 매치시켜주는 객체
     * @return Map(로또 등수, 당첨수)
     */
    private Map<LottoRanking, Long> groupByLottoRanking(LottoMatcher lottoMatcher) {
        return lottoMatcher.match().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private long getAllWinningProfitRate(LottoMatcher lottoMatcher) {
        long profit = getAllWinningProfit(lottoMatcher) - lottoMatcher.getLottoPrice();
        return (long) (((double)profit / lottoMatcher.getLottoPrice()) * 100);
    }

    private long getAllWinningProfit(LottoMatcher lottoMatcher) {
        return groupByLottoRanking(lottoMatcher).entrySet().stream().mapToLong(entry -> {
            LottoRanking ranking = entry.getKey();
            long count = entry.getValue();
            return ranking.getWinningPrice() * count;
        }).sum();
    }
}
