package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoView;
import lotto.vo.LottoVO;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController() {
        lottoService = new LottoService();
        lottoView = new LottoView();
    }

    public List<LottoVO> purchaseLottos(int count) {
        List<LottoVO> lottos = lottoService.purchaseLottos(count)
                .stream().map(LottoVO::new).collect(Collectors.toList());
        lottoView.outputPurchaseResult(lottos);
        return lottos;
    }

}
