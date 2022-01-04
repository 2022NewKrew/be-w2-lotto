package domain.lottery;

import domain.lotto.Lotto;
import java.io.IOException;
import view.read.InputReader;

public class LotteryMachine {

  private Lotto currentWinningLotto;

  private LotteryMachine(Lotto winningLotto) {
    this.currentWinningLotto = winningLotto;
  }

  public static LotteryMachine of(Lotto winningLotto) {
    return new LotteryMachine(winningLotto);
  }


  public static LotteryMachine createEmpty() {
    return new LotteryMachine(null);
  }


  public void setCurrentWinningLotto(Lotto lotto) {
    this.currentWinningLotto = lotto;
  }


  public void setCurrentWinningLotto(InputReader reader) throws IOException {
    currentWinningLotto = reader.getLastWinningLotto();
  }


  public Lotto getCurrentWinningLotto() {
    return currentWinningLotto;
  }

}
