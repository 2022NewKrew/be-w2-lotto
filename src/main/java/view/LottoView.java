package view;

import domain.Lotto;
import domain.LottoList;
import domain.LottoResult;
import domain.Rank;

import java.util.Map;

public class LottoView {
    public void printLottoList(LottoList lottoList){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("수동으로 %d개, 자동으로 %d개를 구매했습니다\n",
                lottoList.getManualCount(), lottoList.getAutoCount()));

        for (Lotto lotto : lottoList.getLottoList()) {
            sb.append(lotto).append("\n");
        }

        System.out.println(sb);
    }

    public void printLottoResult(LottoResult lottoResult){
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n").append("---------\n");

        //Result View
        Map<Rank, Integer> lottoResultMap = lottoResult.getLottoResult();
        lottoResultMap.forEach((rank, count) -> sb.append(printLottoRank(rank, count)));

        // 수익률
        sb.append(String.format("총 수익률은 %.2f%%입니다.\n", lottoResult.getTotalResultPrice()));
        System.out.println(sb);
    }

    private String printLottoRank(Rank rank, int count){
        StringBuilder sb = new StringBuilder();
        if(rank == Rank.NONE){
            return sb.toString();
        }

        sb.append(String.format("%d개 일치", rank.getCountOfMatch()));
        if(rank == Rank.SECOND){
            sb.append(", 보너스 볼 일치");
        }
        sb.append(String.format(" (%d원) - %d개\n", rank.getWinningMoney(), count));

        return sb.toString();
    }
}
