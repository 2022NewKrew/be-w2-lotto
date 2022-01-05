package domain.lottery;

import java.io.IOException;
import view.read.InputReader;

/**
 * 당청 로또를 뽑는 모듈, WinningLottery 의 생성과 반환 역할을 한다.
 *
 * @author leo.jung
 * @since 1.0
 */
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
