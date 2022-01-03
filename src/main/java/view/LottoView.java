package view;

import domain.LottoRank;
import domain.LottoResult;

public class LottoView {
    public void printLottoStatistics(LottoResult lottoResult) {
        System.out.println("당첨통계");
        System.out.println("---------");

        for (LottoRank lottoRank : LottoRank.values()) {
            System.out.printf("%d개 일치 (%d) - %d개", lottoRank.getMatches(), lottoRank.getPrice(), lottoResult.getCountOfMatches().get(lottoRank.getMatches()));
        }
    }
}
