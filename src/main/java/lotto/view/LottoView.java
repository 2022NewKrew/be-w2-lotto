package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class LottoView {

    public void printLottos(List<LottoNumbers> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (LottoNumbers ln : lottos) {
            System.out.println(ln.toString());
        }
    }

    public void printResult(HashMap<Rank, Integer> matchMap, int profitRate) {
        System.out.println("당첨 통계");
        System.out.println("===========");
        for (Rank rank : Rank.values()) {
            printCntOfMatch(rank, matchMap);
        }
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private void printCntOfMatch(Rank rank, HashMap<Rank, Integer> matchMap) {
        if (rank.equals(Rank.NONE)) return;

        System.out.print(rank.getCntOfMatch() + "개 일치");
        if (rank.equals(Rank.SECOND)) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + rank.getWinningMoney() + "원) - " +
                        matchMap.get(rank) + "개");
    }
}
