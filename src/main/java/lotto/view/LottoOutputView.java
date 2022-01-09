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
        lottoResult.addMessage("당첨 통계\n");
        lottoResult.addMessage("---------\n");
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getCountOfMatch() < 3) continue;
            lottoResult.addMessage(rank.getCountOfMatch() + "개 일치 ");
            if (rank.isCheckBonusBall()) lottoResult.addMessage("보너스 볼 일치");
            lottoResult.addMessage("(" + rank.getWinningMoney() + "원)- " +  lottoResult.getRankCount(rank)+  "개\n");
        }
        System.out.printf(lottoResult.getMessage());
        System.out.printf("총 수익률은 %.2f%%입니다.", lottoResult.getYield());
    }

}
