package lotto.application;

import lotto.controller.LottoController;
import lotto.result.LottoRank;
import lotto.result.LottoResult;
import lotto.service.LottoService;
import lotto.vo.LottoVO;
import lotto.view.LottoView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoApplication {
    public static void run(){
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService);

        // 구매금액 입력
        int purchaseCount = LottoView.inputPurchaseAmount(System.in);

        // 수동 구매 정보 입력
        List<List<Integer>> userNumbers = LottoView.inputPurchaseByUserNumbers(System.in);

        // 자동 구매
        List<LottoVO> autoLottos = lottoController.purchaseLottos(purchaseCount);

        // 수동 구매
        List<LottoVO> manualLottos = lottoController.purchaseLottoByUserNumbers(userNumbers);

        // 구매 결과 출력
        LottoView.outputPurchaseResult(manualLottos, autoLottos);

        // 지난 주 당첨 번호 입력
        List<Integer> lastWeekLottoNumbers = LottoView.inputLastWeekLottoNumbers(System.in);

        // 지난 주 당첨 보너스 번호 입력
        int bonusBall = LottoView.inputBonusBall(System.in);

        // 당점 결과 출력
        List<LottoVO> lottos = Stream.concat(autoLottos.stream(), manualLottos.stream())
                .collect(Collectors.toList());
        LottoResult lottoResult = lottoController.createLottoResult(lottos, lastWeekLottoNumbers, bonusBall);

        LottoView.outputLottoResult(lottoResult);
    }
}
