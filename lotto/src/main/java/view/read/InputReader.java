package view.read;

import domain.lottery.WinningLotto;
import java.io.IOException;

/**
 * 입력을 담당하는 인터페이스. 해당 인터페이스를 상속받는 구현체는 총 구매 금액과 지난 승리 로또정보를 입력받아 반환해야 한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public interface InputReader {

  int getPurchaseAmount() throws IOException;

  WinningLotto getLastWinningLottery() throws IOException;

}
