package com.kakao.lotto.step2.view;

import com.kakao.lotto.step2.domain.LottoResult;

import java.util.List;

public class LottoResultPrinter {

    private int LOTTO_PRICE = 1000;
    private int THREE_PRIZE = 5000;
    private int FOUR_PRIZE = 50000;
    private int FIVE_PRIZE = 1500000;
    private int SIX_PRIZE = 2000000000;

    private int lottoNumber;
    private List<Integer> results;

    public LottoResultPrinter(LottoResult lottoResult) {
        lottoNumber = lottoResult.getLottoNumber();
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
        int profit = results.get(0) * THREE_PRIZE + results.get(1) * FOUR_PRIZE
                + results.get(2) * FIVE_PRIZE + results.get(3) * SIX_PRIZE;
        System.out.println("총 수익률은 " + (long)profit * 100 / (lottoNumber * LOTTO_PRICE) + "%입니다.");
    }

}
