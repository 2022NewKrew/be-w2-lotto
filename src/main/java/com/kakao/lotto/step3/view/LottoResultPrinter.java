package com.kakao.lotto.step3.view;

import com.kakao.lotto.step3.core.LottoResult;
import com.kakao.lotto.step3.core.Rank;

import java.util.Map;

public class LottoResultPrinter {

    private int profitRate;
    private Map<Rank, Integer> results;

    public LottoResultPrinter(LottoResult lottoResult) {
        profitRate = lottoResult.getProfitRate();
        this.results = lottoResult.getResults();
    }

    private void printResult(Rank rank) {
        String resultString = " ";
        if(rank == Rank.SECOND)
            resultString = ", 보너스 볼 일치";
        System.out.println(String.format("%d개 일치%s(%d원)- %d개",
                rank.getCountOfMatch(), resultString, rank.getWinningMoney(), results.get(rank)));
    }

    // 결과를 출력해줍니다.
    public void printResults() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks) {
            printResult(rank);
        }
    }

    // 수익률을 출력해줍니다.
    public void printProfitRate() {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
