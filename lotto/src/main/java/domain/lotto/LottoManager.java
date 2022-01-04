package domain.lotto;

import domain.lottery.LotteryMachine;
import domain.statistics.Statistics;
import java.io.IOException;
import utils.LottoUtils;
import view.read.BufferedInputReader;
import view.read.InputReader;
import view.write.BufferedOutputWriter;
import view.write.OutputWriter;

/**
 * 로또 프로그램 동작 및 입출력 연계, 로또 도메인을 컨트롤 한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class LottoManager {

  private final InputReader reader;
  private final OutputWriter writer;
  private final LottoWallet wallet;
  private final LotteryMachine lotteryMachine;

  public LottoManager() {
    this.reader = BufferedInputReader.create();
    this.writer = BufferedOutputWriter.create();
    this.wallet = LottoWallet.createEmpty();
    this.lotteryMachine = LotteryMachine.createEmpty();
  }


  public void run() throws IOException {
    buyLotto();
    reportBuyingInformation();
    setLastWinningNumber();
    reportWinningStatistics();
  }


  private void buyLotto() throws IOException {
    int purchaseAmount = reader.getPurchaseAmount();
    int quantity = LottoUtils.getMaxPurchaseQuantity(purchaseAmount);
    wallet.addLotto(quantity);
  }


  private void reportBuyingInformation() throws IOException {
    writer.write(wallet);
  }


  private void setLastWinningNumber() throws IOException {
    lotteryMachine.setCurrentWinningLotto(reader);
  }


  private void reportWinningStatistics() throws IOException {
    Statistics statistics = Statistics.of(lotteryMachine.getCurrentWinningLotto(), wallet);
    writer.write(statistics);
  }



}
