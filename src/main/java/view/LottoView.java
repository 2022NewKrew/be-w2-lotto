package view;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoResult;

import java.util.List;

public class LottoView {
    public void printPurchaseAmount(int purchaseAmount) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseAmount);
    }

    public void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoStatistics(LottoResult lottoResult) {
        System.out.println("당첨통계");
        System.out.println("---------");

        for (LottoRank lottoRank : LottoRank.values()) {
            Integer matchCount = lottoResult.getCountOfMatches().get(lottoRank);

            System.out.printf(
                    "%d개 일치, %s (%d원) - %d개\n",
                    lottoRank.getMatches(),
                    lottoRank.isBonus() ? "보너스볼 일치" : "",
                    lottoRank.getPrice(),
                    matchCount == null ? 0 : matchCount
            );
        }
    }
}
