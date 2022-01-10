package controller;

import domain.LottoManager;
import domain.lottery.WinningLotto;
import domain.lotto.LottoList;
import domain.statistics.YieldStatistics;

public class LottoService {

  public LottoList buyLotto(int purchaseAmount, LottoList manuallyBuyLotto) {
    LottoManager buyManager = new LottoManager();
    return buyManager.buyLotto(purchaseAmount, manuallyBuyLotto);
  }

  public YieldStatistics simulateLottery(WinningLotto winningLotto, LottoList wallet) {
    return YieldStatistics.of(winningLotto, wallet);
  }

}
