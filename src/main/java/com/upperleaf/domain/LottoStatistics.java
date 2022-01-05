package com.upperleaf.domain;

import com.upperleaf.domain.lotto.LottoRanking;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistics {

    private final LottoMatcher lottoMatcher;

    public LottoStatistics(LottoMatcher lottoMatcher) {
        this.lottoMatcher = lottoMatcher;
    }

    /**
     * 로또 등수에 따라 그룹화 해주는 메서드
     * @return Map(로또 등수, 당첨수)
     */
    public Map<LottoRanking, Long> groupByLottoRanking() {
        return lottoMatcher.match().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * 자신이 쓴 돈에 대한 수익률을 계산하는 함수
     * (평가 금액 - 원금) / 원금 * 100
     * @param lottoPaymentInfo 로또 지불 정보 객체
     * @return 수익률
     */
    public long getAllWinningProfitRate(LottoPaymentInfo lottoPaymentInfo) {
        long profit = getAllWinningProfit() - lottoPaymentInfo.getPaymentAmount();
        return (long) (((double)profit / lottoPaymentInfo.getPaymentAmount()) * 100);
    }

    /**
     * 로또 당첨이 되면서 얻게 된 모든 수익의 합
     * @return 로또 당첨금 수익 합
     */
    public long getAllWinningProfit() {
        return groupByLottoRanking().entrySet().stream().mapToLong(entry -> {
            LottoRanking ranking = entry.getKey();
            long count = entry.getValue();
            return ranking.getWinningPrice() * count;
        }).sum();
    }
}
