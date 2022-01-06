package com.upperleaf.view;

import com.upperleaf.domain.LottoMatcher;
import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.LottoStatistics;
import com.upperleaf.domain.lotto.LottoRanking;
import com.upperleaf.domain.lotto.Lottos;

import java.util.Arrays;
import java.util.Map;

public class LottosPrinter {

    private final LottoStatistics lottoStatistics = new LottoStatistics();
    /**
     * 로또 리스트 데이터를 출력하는 메서드
     * @param lottos 출력할 로또 리스트
     */
    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + "개를 구매했습니다.");
        lottos.getLottosInfo().forEach(System.out::println);
    }

    public void printResults(LottoMatcher lottoMatcher) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<LottoRanking, Long> groupRanking = lottoStatistics.groupByLottoRanking(lottoMatcher);
        Arrays.stream(LottoRanking.values()).forEach(ranking -> printResult(ranking, groupRanking));
    }

    public void printProfit(LottoMatcher lottoMatcher, LottoPaymentInfo paymentInfo) {
        long profitRate = lottoStatistics.getAllWinningProfitRate(lottoMatcher, paymentInfo);
        System.out.println("총 수익률은 " + profitRate + "% 입니다.");
    }

    private void printResult(LottoRanking ranking, Map<LottoRanking, Long> groupRanking) {
        if(ranking ==  LottoRanking.NONE) {
            return;
        }
        printResultNotNoneRanking(ranking, groupRanking);
    }

    private void printResultNotNoneRanking(LottoRanking ranking, Map<LottoRanking, Long> groupRanking) {
        long count = groupRanking.getOrDefault(ranking, 0L);
        if (ranking.isMatchedBonus()) {
            System.out.println(ranking.getMatchNumber() + "개 일치, 보너스 볼 일치 (" + ranking.getWinningPrice() + "원)- " + count + "개");
            return;
        }
        System.out.println(ranking.getMatchNumber() + "개 일치 (" + ranking.getWinningPrice() + "원)- " + count + "개");
    }
}
