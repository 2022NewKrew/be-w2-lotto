package view.read;

import domain.lottery.WinningLottery;
import java.io.IOException;

public interface InputReader {

  int getPurchaseAmount() throws IOException;
  WinningLottery getLastWinningLottery() throws IOException;

}
