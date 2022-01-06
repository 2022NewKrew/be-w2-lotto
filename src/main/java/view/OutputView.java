package view;

import model.*;

import java.util.Map;

public class OutputView {
    private static final String STAT_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String STAT_MESSAGE = "%d개 일치 (%d원)- %d개";
    private OutputView() {
    }

    public static void printLottos(Lottos lottos) {
        System.out.println("수동 " + lottos.getManualCount() + "개, 자동 " + lottos.getAutoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        System.out.print("[ ");
        for(LottoNumber lottoNumber: lotto.getNumbers()){
            printLottoNumber(lottoNumber);
        }
        System.out.println("]");
    }

    public static void printLottoNumber(LottoNumber lottoNumber) {
        System.out.print(lottoNumber.getNumber()+" ");
    }

    public static void printLottoWinningStats(RankResult rankResults) {
        System.out.println("\n당첨 통계\n----------");
        for(LottoRanks rank: LottoRanks.values()){
            printLottoWinningStat(rank,rankResults.getCountByRank(rank));
        }
    }

    private static void printLottoWinningStat(LottoRanks rank, int count){
        if(rank == LottoRanks.NOWINNING){
            return;
        }
        if(rank == LottoRanks.SECOND){
            System.out.println(String.format(STAT_SECOND_MESSAGE,rank.getCountOfMatch(),rank.getWinningMoney(),count));
            return;
        }
        System.out.println(String.format(STAT_MESSAGE,rank.getCountOfMatch(),rank.getWinningMoney(),count));
    }

    public static void printLottoYield(long yield){
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}

