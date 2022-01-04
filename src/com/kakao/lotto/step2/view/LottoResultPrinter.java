package com.kakao.lotto.step2.view;

import com.kakao.lotto.step2.domain.LottoResult;

import java.util.List;

public class LottoResultPrinter {

    private int profitRate;
    private List<Integer> results;

    public LottoResultPrinter(LottoResult lottoResult) {
        profitRate = lottoResult.getProfitRate();
        this.results = lottoResult.getResults();
    }

    // 결과를 출력해줍니다.
    public void printResults() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + results.get(0) + "개");
        System.out.println("4개 일치 (50000원)- " + results.get(1) + "개");
        System.out.println("5개 일치 (1500000원)- " + results.get(2) + "개");
        System.out.println("6개 일치 (2000000000원)- " + results.get(3) + "개");
    }

    // 수익률을 출력해줍니다.
    public void printProfitRate() {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
