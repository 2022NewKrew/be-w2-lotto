package domain.lottery;

import domain.lotto.Lotto;

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
