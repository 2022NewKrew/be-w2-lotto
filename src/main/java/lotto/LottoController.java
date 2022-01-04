package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoSevice lottoSevice;
    private final LottoView lottoView;

    public LottoController() {
        lottoSevice = new LottoSevice();
        lottoView = new LottoView();
    }

    public List<LottoDto> purchaseLottos(int count) {
        List<LottoDto> lottos = lottoSevice.purchaseLottos(count)
                .stream().map(LottoDto::new).collect(Collectors.toList());
        lottoView.outputPurchaseResult(lottos);
        return lottos;
    }

}
