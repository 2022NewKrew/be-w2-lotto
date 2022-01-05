package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController() {
        lottoService = new LottoService();
        lottoView = new LottoView();
    }

    public List<LottoDto> purchaseLottos(int count) {
        List<LottoDto> lottos = lottoService.purchaseLottos(count)
                .stream().map(LottoDto::new).collect(Collectors.toList());
        lottoView.outputPurchaseResult(lottos);
        return lottos;
    }

}
