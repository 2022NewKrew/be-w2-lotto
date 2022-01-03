package com.upperleaf.view;

import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.LottoRanking;
import com.upperleaf.domain.Lottos;

import java.util.Arrays;
import java.util.Map;

public class LottosPrinter {

    /**
     * 로또 리스트 데이터를 출력하는 메서드
     * @param lottos 출력할 로또 리스트
     */
    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + "개를 구매했습니다.");
        System.out.println(lottos.getLottosInfo());
    }

    /**
     * 로또 결과를 출력하는 메서드
     * @param paymentInfo 수익률을 계산하기 위한 지불 정보
     * @param results 로또 결과
     */
    public void printResultsAndProfit(LottoPaymentInfo paymentInfo, LottoResults results) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoRanking.values()).forEach(ranking -> printResult(ranking, results));
        printProfit(paymentInfo, results);
    }

    private void printProfit(LottoPaymentInfo paymentInfo, LottoResults results) {
        long profit = (getProfit(results) - paymentInfo.getPaymentAmount());
        long profitRate = (long) (((double)profit / paymentInfo.getPaymentAmount()) * 100);
        System.out.println("총 수익률은 " + profitRate + "% 입니다.");
    }

    private void printResult(LottoRanking ranking, LottoResults results) {
        if(ranking ==  LottoRanking.NONE) {
            return;
        }
        printResultNotNone(ranking, results);
    }

    private void printResultNotNone(LottoRanking ranking, LottoResults results) {
        Map<LottoRanking, Long> resultMap = results.getLottoRankingGroup();
        if(resultMap.containsKey(ranking)) {
            long count = resultMap.get(ranking);
            System.out.println(ranking.getMatchNumber() + "개 일치 (" + ranking.getWinningPrice() + "원)- " + count + "개");
            return;
        }
        System.out.println(ranking.getMatchNumber() + "개 일치 (" + ranking.getWinningPrice() + "원)- " + "0개");
    }

    private long getProfit(LottoResults results) {
        return results.getLottoRankingGroup().entrySet().stream().mapToLong(result -> {
            LottoRanking ranking = result.getKey();
            long count = result.getValue();
            return ranking.getWinningPrice() * count;
        }).sum();
    }
}
