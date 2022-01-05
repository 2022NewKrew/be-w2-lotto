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

    // 결과를 출력해줍니다.
    public void printResults() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + results.get(Rank.FOURTH) + "개");
        System.out.println("4개 일치 (50000원)- " + results.get(Rank.THIRD) + "개");
        System.out.println("5개 일치 (1500000원)- " + results.get(Rank.SECOND) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + results.get(Rank.SECOND_BONUS) + "개");
        System.out.println("6개 일치 (2000000000원)- " + results.get(Rank.FIRST) + "개");
    }

    // 수익률을 출력해줍니다.
    public void printProfitRate() {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
