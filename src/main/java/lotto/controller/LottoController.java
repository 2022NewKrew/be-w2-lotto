package lotto.controller;

import lotto.domain.Lotto;
import lotto.request.PurchaseRequest;
import lotto.request.ResultRequest;
import lotto.result.LottoResult;
import lotto.service.LottoService;
import lotto.view.LottoView;
import lotto.vo.LottoVO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<LottoVO> purchaseLottos(int count) {
        return lottoService.purchaseLottos(count)
                .stream().map(LottoVO::new).collect(Collectors.toList());
    }

    public List<LottoVO> purchaseLottoByUserNumbers(List<List<Integer>> userNumbers) {
        return lottoService.purchaseLottoByUserNumbers(userNumbers)
                .stream().map(LottoVO::new).collect(Collectors.toList());
    }

    public List<LottoVO> purchaseLotto(PurchaseRequest purchaseRequest) {
        List<LottoVO> autoLottos = purchaseLottos(purchaseRequest.purchasableLottoCount());
        List<LottoVO> manualLottos = purchaseLottoByUserNumbers(purchaseRequest.getRequestManulLottos());
        LottoView.outputPurchaseResult(manualLottos, autoLottos);
        return Stream.concat(autoLottos.stream(), manualLottos.stream()).collect(Collectors.toList());
    }

    public LottoResult createLottoResult(List<LottoVO> lottos, List<Integer> lastWeekLottoNumbers, int bonusBall) {
        return lottoService.createLottoResult(lottos.stream().map(lottoVO -> new Lotto(lottoVO.getNumbers())).collect(Collectors.toList()), lastWeekLottoNumbers, bonusBall);
    }

    public LottoResult createLottoResult(ResultRequest resultRequest) {
        LottoResult lottoResult = createLottoResult(resultRequest.getLottos(), resultRequest.getLastWeekLottoNumbers(), resultRequest.getBonusBall());
        LottoView.outputLottoResult(lottoResult);
        return lottoResult;
    }

}
