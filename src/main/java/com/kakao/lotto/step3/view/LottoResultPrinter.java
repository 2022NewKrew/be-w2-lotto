package com.kakao.lotto.step3.view;

import com.kakao.lotto.step3.core.LottoResult;
import com.kakao.lotto.step3.core.Rank;

import java.util.Arrays;
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
        Arrays.stream(Rank.values()).forEach(rank -> {
            String resultString = "개 일치 (";
            if(rank == Rank.SECOND)
                resultString = "개 일치, 보너스 볼 일치(";
            System.out.println(String.valueOf(rank.getCountOfMatch()) + resultString
                    + String.valueOf(rank.getWinningMoney()) + "원)- " + String.valueOf(results.get(rank)) + "개");
                });
    }

    // 수익률을 출력해줍니다.
    public void printProfitRate() {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
