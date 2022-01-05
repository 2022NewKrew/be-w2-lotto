package lotto.util;

import lotto.constant.Msg;
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

    public void printRank(Map<Rank, Integer> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            System.out.println(String.format(
                    entry.getKey() != Rank.SECOND ? Msg.OUTPUT_RANK.getMsg() : Msg.OUTPUT_RANK_2ND.getMsg()
                    ,entry.getKey().getCountOfMatch()
                    ,entry.getKey().getWinningMoney()
                    ,entry.getValue()));
        }
    }

    public void printBenefit(double benefit) {
        System.out.println(String.format("총 수익률은 %.2f%%입니다.", benefit));
    }
}
