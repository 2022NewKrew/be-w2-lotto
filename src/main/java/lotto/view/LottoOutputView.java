package lotto.view;

import lotto.configure.LottoConfigure;
import lotto.result.LottoResult;
import lotto.vo.LottoVO;

import java.util.Collections;
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

    public static void outputLottoResult(List<LottoResult> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        long totalProfit = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.getCountOfMatch() < LottoResult.FIFTH.getCountOfMatch()) continue;
            long hit = lottoResult.getCountOfMatch();
            long reward = lottoResult.getWinningMoney();
            long count = Collections.frequency(lottoResults, lottoResult);
            totalProfit += count * reward;
            System.out.printf("%d개 일치 ", hit);
            if (lottoResult.isCheckBonusBall()) System.out.print("보너스 볼 일치");
            System.out.printf("(%d원)- %d개\n", reward, count);
        }
        long totalLoss = (long) LottoConfigure.LOTTO_PRICE * lottoResults.size();
        System.out.printf("총 수익률은 %.2f%%입니다.", ((double) totalProfit / (double) totalLoss - 1) * 100);
    }

}
