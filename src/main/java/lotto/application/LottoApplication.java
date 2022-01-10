package lotto.application;

import lotto.controller.LottoController;
import lotto.request.PurchaseRequest;
import lotto.request.ResultRequest;
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

        // PurchaseRequest 생성 (구매금액 & 수동 구매 정보 입력)
        PurchaseRequest purchaseRequest = new PurchaseRequest(LottoView.inputPurchaseAmount(System.in), LottoView.inputPurchaseByUserNumbers(System.in));

        // 로또 구매 & 결과 출력 (자동 구매 & 수동 구매)
        List<LottoVO> lottos = lottoController.purchaseLotto(purchaseRequest);

        // ResultRequest 생성 (지난 주 당첨 번호 & 보너스 번호 입력)
        ResultRequest resultRequest = new ResultRequest(lottos, LottoView.inputLastWeekLottoNumbers(System.in), LottoView.inputBonusBall(System.in));

        // 당첨 확인 & 결과 출력
        lottoController.createLottoResult(resultRequest);
    }
}
