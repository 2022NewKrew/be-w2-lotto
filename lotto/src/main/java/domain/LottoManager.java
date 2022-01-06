package domain;

import domain.lottery.LotteryMachine;
import domain.lotto.Lotto;
import domain.lotto.LottoWallet;
import domain.statistics.YieldStatistics;
import java.io.IOException;
import java.util.List;
import view.read.BufferedInputReader;
import view.read.InputReader;
import view.write.BufferedOutputWriter;
import view.write.OutputWriter;

/**
 * 로또 구매, 입출력, 당첨로또 추첨, 통계 리포트 등 로또 흐름을 관리하는 객체
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
    int availableQuantity = getMaxPurchaseQuantity(purchaseAmount);
    List<Lotto> manuallyBuyLotto = reader.getManualLottoListToBuy(availableQuantity);
    wallet.addAll(manuallyBuyLotto);
    wallet.addRandomGenerated(availableQuantity - manuallyBuyLotto.size());
  }


  private int getMaxPurchaseQuantity(int amount) {
    return amount / Lotto.PRICE;
  }


  private void reportBuyingInformation() throws IOException {
    writer.write(wallet);
  }


  private void setLastWinningNumber() throws IOException {
    lotteryMachine.generateWinningLottery(reader);
  }


  private void reportWinningStatistics() throws IOException {
    YieldStatistics statistics = YieldStatistics.of(lotteryMachine.getCurrentWinningLottery(),
        wallet);
    writer.write(statistics);
  }

}
