package view.read;

import domain.lotto.Lotto;
import java.io.IOException;

public interface InputReader {

  int getPurchaseAmount() throws IOException;
  Lotto getLastWinningLotto() throws IOException;

}
