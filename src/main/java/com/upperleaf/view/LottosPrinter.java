package com.upperleaf.view;

import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.LottoStatistics;
import com.upperleaf.domain.lotto.LottoRanking;
import com.upperleaf.domain.lotto.Lottos;

import java.util.Arrays;
import java.util.Map;

public class LottosPrinter {
    /**
     * 로또 리스트 데이터를 출력하는 메서드
     * @param lottos 출력할 로또 리스트
     */
    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + "개를 구매했습니다.");
        lottos.getLottosInfo().forEach(System.out::println);
    }

    /**
     * 로또 결과를 출력하는 메서드
     * @param lottoStatistics 로또와 관련된 통계 정보를 반환하는 객체
     */

    public void printResults(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoRanking.values()).forEach(ranking -> printResult(ranking, lottoStatistics));
    }

    public void printProfit(LottoStatistics lottoStatistics, LottoPaymentInfo paymentInfo) {
        long profitRate = lottoStatistics.getAllWinningProfitRate(paymentInfo);
        System.out.println("총 수익률은 " + profitRate + "% 입니다.");
    }

    private void printResult(LottoRanking ranking, LottoStatistics aggregate) {
        if(ranking ==  LottoRanking.NONE) {
            return;
        }
        printResultNotNoneRanking(ranking, aggregate);
    }

    private void printResultNotNoneRanking(LottoRanking ranking, LottoStatistics aggregate) {
        Map<LottoRanking, Long> resultMap = aggregate.groupByLottoRanking();
        long count = resultMap.getOrDefault(ranking, 0L);
        if (ranking.isMatchedBonus()) {
            System.out.println(ranking.getMatchNumber() + "개 일치, 보너스 볼 일치 (" + ranking.getWinningPrice() + "원)- " + count + "개");
            return;
        }
        System.out.println(ranking.getMatchNumber() + "개 일치 (" + ranking.getWinningPrice() + "원)- " + count + "개");
    }
}
