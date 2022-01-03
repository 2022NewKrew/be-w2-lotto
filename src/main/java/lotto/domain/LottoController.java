package lotto.domain;

import lotto.dto.LottoPurchaseDto;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public LottoPurchaseDto buy(int price) {
        return lottoService.buy(price);
    }
}
