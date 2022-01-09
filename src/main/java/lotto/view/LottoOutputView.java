package lotto.view;

import lotto.result.LottoRank;
import lotto.result.LottoResult;
import lotto.vo.LottoVO;

import java.util.List;

public class LottoOutputView {

    public static void outputPurchaseResult(List<LottoVO> manualLottos, List<LottoVO> autoLottos) {
        System.out.println("수동으로 " + manualLottos.size() + "장, 자동으로 " + autoLottos.size() + "개를 구매했습니다.");
        for (LottoVO lotto : manualLottos) {
            System.out.println(lotto.getNumbers().toString());
        }
        for (LottoVO lotto : autoLottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void outputLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getCountOfMatch() < 3) continue;
            System.out.printf("%d개 일치 ", rank.getCountOfMatch());
            if (rank.isCheckBonusBall()) System.out.print("보너스 볼 일치");
            System.out.printf("(%d원)- %d개\n", rank.getWinningMoney(), lottoResult.getRankCount(rank));
        }
        System.out.printf("총 수익률은 %.2f%%입니다.", lottoResult.getYield());
    }

}
