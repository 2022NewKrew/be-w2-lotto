package domain;

import java.util.Map;

public class LottoProfitRate {

    public static double createProfitRate(Map<LottoRank, Integer> lottoRankResult, int purchasedAmount) {
        double profitRate = 0.0;
        for (Map.Entry<LottoRank, Integer> resultIndex : lottoRankResult.entrySet()) {
            profitRate += (resultIndex.getKey().getMoney() * resultIndex.getValue());
            System.out.println(resultIndex.getKey().getCountOfMatch() + "개 일치 " + "(" + resultIndex.getKey().getMoney() + ")" + "-" + resultIndex.getValue() + "개");
        }
        System.out.println("총 수익률은 " + (profitRate - purchasedAmount) / (purchasedAmount * 100) + "%입니다");
        return (profitRate - purchasedAmount) / (purchasedAmount * 100);
    }
}

