package lotto.application;

import lotto.controller.LottoController;
import lotto.result.LottoResult;
import lotto.service.LottoService;
import lotto.vo.LottoVO;
import lotto.view.LottoView;

import java.util.List;

public class LottoApplication {
    public static void run(){
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService);

        // 구매금액 입력
        int purchaseCount = LottoView.inputPurchaseAmount(System.in);

        // 자동 구매
        List<LottoVO> lottos = lottoController.purchaseLottos(purchaseCount);

        // 지난 주 당첨 번호 입력
        List<Integer> lastWeekLottoNumbers = LottoView.inputLastWeekLottoNumbers(System.in);

        // 지난 주 당첨 보너스 번호 입력
        int bonusBall = LottoView.inputBonusBall(System.in);

        // 당점 결과 출력
        List<LottoResult> lottoResults = LottoResult.createLottoResults(lottos, lastWeekLottoNumbers, bonusBall);

        LottoView.outputLottoResult(lottoResults);
    }
}
