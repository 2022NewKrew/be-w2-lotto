package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoView;
import lotto.vo.LottoVO;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<LottoVO> purchaseLottos(int count) {
        List<LottoVO> lottos = lottoService.purchaseLottos(count)
                .stream().map(LottoVO::new).collect(Collectors.toList());
        LottoView.outputPurchaseResult(lottos);
        return lottos;
    }

}
