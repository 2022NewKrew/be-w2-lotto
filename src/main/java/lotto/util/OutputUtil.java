package lotto.util;

import lotto.constant.Rank;
import lotto.dto.LottoGameDto;

import java.util.List;
import java.util.Map;

public class OutputUtil {

    public void PrintPurchaseGameCnt(int purchaseGameCnt) {
        System.out.println(String.format("%d개를 구매했습니다.", purchaseGameCnt));
    }

    public void printPurchaseGames(List<LottoGameDto> lottoGames) {
        for (LottoGameDto lottoGame : lottoGames) {
            System.out.println(lottoGame);
        }
    }

    public void printRank(Map<Integer, Integer> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Map.Entry<Integer, Integer> entry : ranks.entrySet()) {
            int winningMoney = Rank.valueOf(entry.getKey()).getWinningMoney();
            System.out.println(String.format("%d개 일치 (%d원)- %d개"
                    ,entry.getKey()
                    ,winningMoney
                    ,entry.getValue()));
        }
    }

    public void printBenefit(double benefit) {
        System.out.println(String.format("총 수익률은 %.2f%%입니다.", benefit));
    }
}
