package lotto.domain;

import lotto.constant.Rank;
import lotto.dto.LottoPurchaseDto;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public LottoPurchaseDto autoBuy(int money) {
        return lottoService.autoBuy(money);
    }

    public Map<Rank, Integer> checkRank(LottoPurchaseDto lotto, List<Integer> winningNumber, int bonusNumber) {
        return lottoService.checkRank(lotto, winningNumber, bonusNumber);
    }

    public Long getTotalWinningMoney(Map<Rank, Integer> ranks) {
        return lottoService.getTotalWinningMoney(ranks);
    }
}
