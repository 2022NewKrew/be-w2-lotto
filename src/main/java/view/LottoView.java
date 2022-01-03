package view;

import domain.LottoRank;
import domain.LottoResult;

public class LottoView {
    public void printPurchaseAmount(int purchaseAmount) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseAmount);
    }
    public void printLottoStatistics(LottoResult lottoResult) {
        System.out.println("당첨통계");
        System.out.println("---------");

        for (LottoRank lottoRank : LottoRank.values()) {
            Integer matchCount = lottoResult.getCountOfMatches().get(lottoRank.getMatches());

            System.out.printf(
                    "%d개 일치 (%d원) - %d개\n",
                    lottoRank.getMatches(),
                    lottoRank.getPrice(),
                    matchCount == null ? 0 : matchCount
            );
        }
    }
}
