package lotto.util;

import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoStatistics;

import java.util.Map;

public class OutputUtil {

    public static void printLottoCollection(LottoCollection lottoCollection) {
        for (Lotto lotto : lottoCollection.getLottoCollection()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Map.Entry<Rank, Integer> entry : lottoStatistics.getRankCount().entrySet()) {
            Rank rank = entry.getKey();
            if(rank == Rank.RAIN_CHECK) continue;
            System.out.println(String.format("%d개 일치 (%d원)- %d개", rank.getCountOfMatch(), rank.getWinningMoney(), entry.getValue()));
        }
        System.out.println(String.format("총 수익률은 %.2f%%입니다.", lottoStatistics.getProfit()));
    }
}
