package view.read;

import java.io.IOException;

public interface InputReader {

  int getPurchaseAmount() throws IOException;
  int getLastWinningNumber() throws IOException;

}
