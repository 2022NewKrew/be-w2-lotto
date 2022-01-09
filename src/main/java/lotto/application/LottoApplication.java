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

        List<LottoVO> lottos = lottoController.purchaseLottos(LottoView.inputPurchaseAmount(System.in));

        List<Integer> lastWeekLottoNumbers = LottoView.inputLastWeekLottoNumbers(System.in);

        int bonusBall = LottoView.inputBonusBall(System.in);

        List<LottoResult> lottoResults = LottoResult.createLottoResults(lottos, lastWeekLottoNumbers, bonusBall);

        LottoView.outputLottoResult(lottoResults);
    }
}
