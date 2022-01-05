package lotto.domain;

import lotto.dto.LottoPurchaseDto;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public LottoPurchaseDto autoBuy(int money) {
        return lottoService.autoBuy(money);
    }

    public Map<Integer, Integer> checkRank(LottoPurchaseDto lotto, List<Integer> winningNumber) {
        return lottoService.checkRank(lotto, winningNumber);
    }

    public Long getTotalWinningMoney(Map<Integer, Integer> ranks) {
        return lottoService.getTotalWinningMoney(ranks);
    }
}
