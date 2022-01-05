package domain.lottery;

import domain.lotto.Lotto;

/**
 * LotteryMachine 에 의해서 당첨된 로또,
 * 당청 로또 번호와 보너스 넘버로 이루어 져있다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class WinningLottery {

  private final Lotto currentWinningLotto;
  private final Integer bonusNumber;

  private WinningLottery(Lotto winningLotto, Integer bonusNumber) {
    this.currentWinningLotto = winningLotto;
    this.bonusNumber = bonusNumber;
  }

  public static WinningLottery of(Lotto winningLotto, Integer bonusNumber) {
    return new WinningLottery(winningLotto, bonusNumber);
  }


  public Lotto getCurrentWinningLotto() {
    return currentWinningLotto;
  }

  public Integer getBonusNumber() {
    return bonusNumber;
  }

}
