package domain.lottery;

import java.io.IOException;
import view.read.InputReader;

public class LotteryMachine {

  private WinningLottery winningLottery;

  private LotteryMachine() {
    this.winningLottery = null;
  }

  public static LotteryMachine createEmpty() {
    return new LotteryMachine();
  }

  public void generateWinningLottery(InputReader reader) throws IOException {
    this.winningLottery = reader.getLastWinningLottery();
  }


  public WinningLottery getCurrentWinningLottery() {
    return winningLottery;
  }
}
