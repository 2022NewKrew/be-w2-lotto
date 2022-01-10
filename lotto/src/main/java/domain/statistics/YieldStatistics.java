package domain.statistics;

import domain.lottery.WinningLotto;
import domain.lotto.Lotto;
import domain.lotto.LottoList;

/**
 * 구매금액 기반 Statistics 구현체, 수익률 관련 통계를 계산하고 표현한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class YieldStatistics extends Statistics {

  private final int buyAmount;

  private YieldStatistics(WinningLotto winningLotto, LottoList wallet) {
    super(winningLotto, wallet);
    this.buyAmount = calculateBuyAmount(wallet);
  }


  public static YieldStatistics of(WinningLotto winningLotto, LottoList wallet) {
    return new YieldStatistics(winningLotto, wallet);
  }


  private int calculateBuyAmount(LottoList wallet) {
    return wallet.size() * Lotto.PRICE;
  }


  private int getProfitRate() {
    return (int) ((double) getProfitAmount() / buyAmount * 100 - 100);
  }

}
